package com.hhh.study.MQTT;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ClientMQTT {

    //tcp://MQTT安装的服务器地址:MQTT定义的端口号
    public static final String HOST = "tcp://post-cn-4591jqut71m.mqtt.aliyuncs.com:1883";
    //定义一个主题
    public static final String TOPIC = "WINSENSE_OS_DEVICE/HHTest";
    //定义MQTT的ID，可以在MQTT服务配置中指定
    private static final String clientid = "client11";
    private MqttConnectOptions options;

    private MqttClient client;
    private MqttTopic topic11;
    private String userName = "Signature|LTAI4FuE8XdwxEYWTnnFQprL|post-cn-4591jqut71m";
    private char[] passWord = macSignature("GID_OS_DEVICE_DEV@@@OS_DEVICE_1","xzBxYtiA3OHgiYdowyyjc06ysW1v1N").toCharArray();

    public ClientMQTT() throws NoSuchAlgorithmException, InvalidKeyException {
    }

    private static String macSignature(String text,
                                       String secretKey) throws InvalidKeyException, NoSuchAlgorithmException {
        Charset charset = Charset.forName("UTF-8");
        String algorithm = "HmacSHA1";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(secretKey.getBytes(charset), algorithm));
        byte[] bytes = mac.doFinal(text.getBytes(charset));
        return new String(Base64.encodeBase64(bytes), charset);
    }

    private void start() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置连接的用户名
            options.setUserName(userName);
            // 设置连接的密码
            options.setPassword(passWord);
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 设置回调
            client.setCallback(new MqttCallbackExtended() {

                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("connectionLost~~~~~~~~~~");
                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

                    System.out.println("messageArrived~~~~~~~~~~"+s+","+mqttMessage.toString());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                    System.out.println("deliveryComplete~~~~~~~~~"+iMqttDeliveryToken.toString());
                }

                @Override
                public void connectComplete(boolean b, String s) {
                    System.out.println("connectComplete~~~~~~~~~~~"+b+","+s);
                }
            });
            MqttTopic topic = client.getTopic(TOPIC);
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            options.setWill(topic, "close".getBytes(), 2, true);

            client.connect(options);
            //订阅消息
            int[] Qos  = {1};
            String[] topic1 = {TOPIC};
            client.subscribe(topic1, Qos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MqttException, InvalidKeyException, NoSuchAlgorithmException {
        ClientMQTT client = new ClientMQTT();
        client.start();
    }

}
