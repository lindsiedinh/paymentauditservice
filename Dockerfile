FROM maprtech/pacc:6.0.1_5.0.0_centos7

RUN mkdir -p /usr/share/mapr-apps/
COPY target/paymentauditservice-0.1.jar /usr/share/mapr-apps/app.jar
CMD [ "java", "-jar", "/usr/share/mapr-apps/app.jar" ]