D:\A_TeachingMaterial\6.JspSpring\workspace\jsp\deploy.sh




1. cd /d/A_TeachingMaterial/6.JspSpring/deploy/jsp

2. git pull

3. mvn clean

4. mvn package

5. mv ./target/jsp-0.0.1-SNAPSHOT.war ./target/jsp.war

6. /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/bin/shutdown.sh

7. rm /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps/jsp.war

8. rm -rf /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps/jsp

9. cp ./target/jsp.war /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps

10 /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/bin/startup.sh

