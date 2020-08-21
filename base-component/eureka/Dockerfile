#网易镜像中心的Java
FROM jdk14:latest
#自己项目Jar包的路径,eurrka.jar可以自定义
COPY target/eureka-1.0-SNAPSHOT.jar eureka.jar
#端口
EXPOSE 8761
#运行Jar
ENTRYPOINT ["java", "-jar", "eureka.jar"]


#FROM centos:latest
#RUN mkdir /usr/local/jdk
#WORKDIR /usr/local/jdk
#ADD jdk-14.0.2_linux-x64_bin.tar.gz /usr/local/jdk
#
#ENV JAVA_HOME /usr/local/jdk/jdk-14.0.2
#ENV JRE_HOME /usr/local/jdk/jdk-14.0.2/jre
#ENV PATH $JAVA_HOME/bin:$PATH