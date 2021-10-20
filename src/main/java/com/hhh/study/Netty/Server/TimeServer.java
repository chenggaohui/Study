package com.hhh.study.Netty.Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

    public void bind(int port){
        EventLoopGroup acceptGroup  =null;
        EventLoopGroup readWriteGroup = null;
        try{
            acceptGroup = new NioEventLoopGroup();
            readWriteGroup = new NioEventLoopGroup();

            ServerBootstrap sb = new ServerBootstrap();
            sb.group(acceptGroup,readWriteGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());

            //绑定端口，同步等待成功
            ChannelFuture channelFuture = sb.bind(port).sync();
            //等待服务端监听端口关闭
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            acceptGroup.shutdownGracefully();
            readWriteGroup.shutdownGracefully();
        }

    }
}
