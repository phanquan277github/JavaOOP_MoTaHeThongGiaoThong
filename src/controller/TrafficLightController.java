package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.TrafficLightView;

public class TrafficLightController{
	private TrafficLightView tflView;
	public TrafficLightController(TrafficLightView trafficLightView) {
		this.tflView = new TrafficLightView();
	}
	
}