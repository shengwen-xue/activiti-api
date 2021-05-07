package com.xsw.neo.service.simplecase;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * 发布端
 *
 * @author xueshengwen
 * @since 2021/1/20 13:31
 */
public class Demo7 {

    public static void main(String[] args) {
        String topic = "";
        String content = "";
        int qos = 1;
        String broker = "";
        String userName = "";
        String password = "";
        String clientId = "";
        // 内存存储
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            // 创建客户端
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            // 创建链接参数
            MqttConnectOptions connOpts = new MqttConnectOptions();
            // 在重新启动和重新连接时记住状态
            connOpts.setCleanSession(false);
            // 设置连接的用户名
            connOpts.setUserName(userName);
            connOpts.setPassword(password.toCharArray());
            // 建立连接
            sampleClient.connect(connOpts);
            // 创建消息
            MqttMessage message = new MqttMessage(content.getBytes());
            // 设置消息的服务质量
            message.setQos(qos);
            // 发布消息
            sampleClient.publish(topic, message);
            // 断开连接
            sampleClient.disconnect();
            // 关闭客户端
            sampleClient.close();
        } catch (MqttException mqttException) {
            System.out.println("ReasonCode：" + mqttException.getReasonCode());
            System.out.println("Message：" + mqttException.getMessage());
            System.out.println("LocalizedMessage：" + mqttException.getLocalizedMessage());
            System.out.println("Cause：" + mqttException.getCause());
            System.out.println("mqttException：" + mqttException);
            mqttException.printStackTrace();
        }
    }
}
