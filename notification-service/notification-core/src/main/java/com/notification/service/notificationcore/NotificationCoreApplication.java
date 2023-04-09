package com.notification.service.notificationcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationCoreApplication {


//	@Value("${component.settings.time}")
//	private String timeZone;

//	@PostConstruct
//	public void init(){
//		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
//	}

	public static void main(String[] args) {
		try{
//			ConfigurableApplicationContext context=
			SpringApplication.run(NotificationCoreApplication.class,args);

//			Runtime.getRuntime().addShutdownHook( new Thread(){
//				@Override
//				public void run(){
////					LOGGER.warn("stopping adapter service !!!");
//
//					final IApplicationCenter appConfig=context.getBean(NotificationAdapterApplicationCentreImpl.class);
//					if (appConfig.stopService()){
////						LOGGER.warn("Notification adapter stopped");
//					}else{
////						LOGGER.warn("Problem in stopping service");
//					}
//					context.close();
//				}
//			});

		}catch (Throwable e){
//			LOGGER.error("Some exception occured while starting Application !!! ",e);
		}
	}


}
