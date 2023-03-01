package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class TimerTest {
	public static void main(String[] args) {
		
		
	}

}




while(true) {
	i--;
	try {
		sleep(1000);// moi lan thuc hien vong lap se ngu 1s
	} catch (InterruptedException ex) {
	}
	
	
	if (i < tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow()) {
		label11.setIcon(imgIconRedHor);
		label22.setIcon(imgIconRedHor);
		if (i > tflModel.getTimeRed() + tflModel.getTimeYellow()) {
			label21.setIcon(imgIconGreenVer);
			label12.setIcon(imgIconGreenVer);
		} else if (i > tflModel.getTimeRed()) {
			label21.setIcon(imgIconYellowVer);
			label12.setIcon(imgIconYellowVer);
		}
	}
	if (i < tflModel.getTimeGreen() + tflModel.getTimeYellow()) {
		label11.setIcon(imgIconGreenHor);
		label21.setIcon(imgIconRedVer);

		label22.setIcon(imgIconGreenHor);
		label12.setIcon(imgIconRedVer);
	}
	if (i < tflModel.getTimeYellow()) {
		label11.setIcon(imgIconYellowHor);
		label21.setIcon(imgIconRedVer);

		label22.setIcon(imgIconYellowHor);
		label12.setIcon(imgIconRedVer);
	}
	//reset giá trị i
	if (i == 0) {
		i = tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow();
	}
}


//for (int i = tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow(); i >= 0; i--) {
//	try {
//		sleep(1000);// moi lan thuc hien vong lap se ngu 1s
//	} catch (InterruptedException ex) {
//	}
//
//	if (i < tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow()) {
//		label11.setIcon(imgIconRedHor);
//		label22.setIcon(imgIconRedHor);
//		
//		lbTime11.setText(i+"");
//		if (i > tflModel.getTimeRed() + tflModel.getTimeYellow()) {
//			label21.setIcon(imgIconGreenVer);
//			label12.setIcon(imgIconGreenVer);
//			
//			lbTime22.setText(i+"");
//		} else if (i > tflModel.getTimeRed()) {
//			label21.setIcon(imgIconYellowVer);
//			label12.setIcon(imgIconYellowVer);
//			
//			lbTime22.setText(i+"");
//		}
//	}
//	if (i < tflModel.getTimeGreen() + tflModel.getTimeYellow()) {
//		label11.setIcon(imgIconGreenHor);
//		label21.setIcon(imgIconRedVer);
//
//		label22.setIcon(imgIconGreenHor);
//		label12.setIcon(imgIconRedVer);
//	}
//	if (i < tflModel.getTimeYellow()) {
//		label11.setIcon(imgIconYellowHor);
//		label21.setIcon(imgIconRedVer);
//
//		label22.setIcon(imgIconYellowHor);
//		label12.setIcon(imgIconRedVer);
//	}
//	if (i == 0) {
//		i = tflModel.getTimeRed() + tflModel.getTimeGreen() + tflModel.getTimeYellow();// reset lai gia tri
//	}
//}