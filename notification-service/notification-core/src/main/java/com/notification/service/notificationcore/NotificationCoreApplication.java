package com.notification.service.notificationcore;

import com.notification.service.notificationcore.controlcenter.IApplicationCenter;
import com.notification.service.notificationcore.controlcenter.NotificationAdapterApplicationCentreImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class NotificationCoreApplication {


	private static final Logger LOGGER= LoggerFactory.getLogger(NotificationCoreApplication.class);

	@Value("${component.settings.time}")
	private String timeZone;

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	}

	public static void main(String[] args) {
		try{
			ConfigurableApplicationContext context= SpringApplication.run(NotificationCoreApplication.class,args);

			Runtime.getRuntime().addShutdownHook( new Thread(){
				@Override
				public void run(){
					LOGGER.warn("stopping adapter service !!!");

					final IApplicationCenter appConfig=context.getBean(NotificationAdapterApplicationCentreImpl.class);
					if (appConfig.stopService()){
						LOGGER.warn("Notification adapter stopped");
					}else{
						LOGGER.warn("Problem in stopping service");
					}
					context.close();

				}
			});

		}catch (Throwable e){
			LOGGER.error("Some exception occured while starting Application !!! ",e);
		}
	}


}
