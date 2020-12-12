## Spring Boot Messaging with Apache Kafka

### Apache Kafka:
Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.
In Kafka, producer will publish messages to topic, which is a stream of messages of a particular type. 
Consumer will subscribe to one or more topics of brokers by pulling the data.

### Spring for Apache Kafka:
The Spring for Apache Kafka (spring-kafka) project applies core Spring concepts to the development of Kafka-based messaging solutions. It provides a "template" as a high-level abstraction for sending messages. It also provides support for Message-driven POJOs with @KafkaListener annotations and a "listener container". These libraries promote the use of dependency injection and declarative. In all of these cases, you will see similarities to the JMS support in the Spring Framework and RabbitMQ support in Spring AMQP.

further references:     
- https://kafka.apache.org/
- https://spring.io/projects/spring-kafka
- https://www.maestralsolutions.com/spring-boot-implementation-for-apache-kafka-with-kafka-tool/


### Project Descriptions:
please see application.properties files in resources folder and select a active profile "dev" or "com" to run project. you can check test methods too.  
steps:
1. Got to the Apache Kafka downloads page(https://kafka.apache.org/downloads) and download the https://kafka.apache.org/download the Scala 2.12 kafka_2.12-0.10.2.1.tgz

2. Next unzip it to a particular location (example: "D:\projects\tools\kafka_2.12-2.5.0"). you can use [tools/kafka_2.12-2.5.0.rar](tools/kafka_2.12-2.5.0.rar) file in the repository instead.
    - important: the directory path to kafka should be without empty space. so do not put kafka inside "program files"

3. We will now start Apache Kafka. This Kafka installation comes with an inbuilt zookeeper. Zookeeper is mainly used to track status of nodes present in Kafka cluster and also to keep track of Kafka topics, messages, etc. Open a command prompt and start the Zookeeper:
```D:\projects\tools\kafka_2.12-2.5.0\bin\windows\zookeeper-server-start.bat D:\projects\tools\kafka_2.12-2.5.0\config\zookeeper.properties```

4. Open a new command prompt and start the Apache Kafka:
```D:\projects\tools\kafka_2.12-2.5.0\bin\windows\kafka-server-start.bat D:\projects\tools\kafka_2.12-2.5.0\config\server.properties```

5. Next start the Spring Boot Application "springboot-messagingkafkaconsumer" and then "springboot-messagingkafkaproducer" by running it as a Java Application.

6. Finally, hit the url as follows "http://localhost:8080/kafka/producer?message=test" to send a message through kafka to consumer and you should see the message in consumer console.

7. Also you can Start the kafka consumer listening to the motahariniaTopic-:
```D:\projects\tools\kafka_2.12-2.5.0\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic motahariniaTopic --from-beginning```

8. Kafka Tool: Kafka tool is a GUI application for managing Kafka clusters. You can download it from here: "https://www.kafkatool.com/download.html".you can use [tools/kafkatool_64bit.exe](tools/kafkatool_64bit.exe) file in the repository instead. Once it is downloaded, we first need to create a cluster as shown below:
```
cluster name: mylocal
kafka cluster version: 2.4
Zookeeper Host: localhost
Zookeeper Port: 2181
chroot path: /
```
After adding the cluster, we will be able to see our broker, topic and consumer because we already ran our Spring Boot application, and it created them.
Click motahariniaTopic in the Topics folder and go to the Properties tab. We need to set types of Key and Message as String if we want to see the values in string format.
Don't forget to click the Update button after you set the types. Now we can go to the Data tab to see the messages that we sent.

### IntellliJ IDEA Configurations:
- IntelijIDEA: Help -> Edit Custom Vm Options -> add these two line:
    - -Dfile.encoding=UTF-8
    - -Dconsole.encoding=UTF-8
- IntelijIDEA: File -> Settings -> Editor -> File Encodings-> Project Encoding: form "System default" to UTF-8. May be it affected somehow.
- IntelijIDEA: File -> Settings -> Editor -> General -> Code Completion -> check "show the documentation popup in 500 ms"
- IntelijIDEA: File -> Settings -> Editor -> General -> Auto Import -> check "Optimize imports on the fly (for current project)"
- IntelijIDEA: File -> Settings -> Editor -> Color Scheme -> Color Scheme Font -> Scheme: Default -> uncheck "Show only monospaced fonts" and set font to "Tahoma"
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Configuration -> Environment -> VM Options: -Dspring.profiles.active=dev
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Code Coverage -> Fix the package in include box

<hr/>
<a href="mailto:eng.motahari@gmail.com?"><img src="https://img.shields.io/badge/gmail-%23DD0031.svg?&style=for-the-badge&logo=gmail&logoColor=white"/></a>


