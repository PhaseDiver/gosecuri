package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

public class WebcamCapture extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// panneau pour les boutons
	private JPanel panelButtons;

	// bouton qui prend la photo
	private JButton buttonPicture;

	// la webcam
	private Webcam webcam;

	// le panneau qui retransmet la webcam
	private WebcamPanel panelWebcam;

	// la photo prise
//	private BufferedImage photo;

	public WebcamCapture(JFrame fenetrePrincipal) {
		panelButtons = new JPanel();

		buttonPicture = new JButton("Prendre la photo");

		buttonPicture.addActionListener(this);

		panelButtons.add(buttonPicture);

		// take control of the webcam
		webcam = Webcam.getDefault();

		panelWebcam = new WebcamPanel(webcam);

		this.setLayout(new BorderLayout());

		this.add(panelWebcam, BorderLayout.CENTER);
		this.add(panelButtons, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * System.out.println("clique");
		 * 
		 * photo = webcam.getImage();
		 * 
		 * AffichePhoto affPhot = new AffichePhoto(photo); affPhot.setVisible(true);
		 * 
		 * CascadeClassifier faceDetector = new CascadeClassifier(
		 * "D:\\Toncourt_Robin\\Documents\\eclipse-workspace-java\\ReconnaissanceFaciale\\biblio\\opencv_2.4.13.6\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml"
		 * ); Mat verif = bufferedImageToMat(photo);
		 * 
		 * MatOfRect faceDetections = new MatOfRect();
		 * faceDetector.detectMultiScale(verif, faceDetections);
		 * 
		 * for (Rect rect : faceDetections.toArray()) { Core.rectangle(verif, new
		 * Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
		 * new Scalar(0, 255, 0)); }
		 * 
		 * String filename = "faceDetection.png";
		 * System.out.println(String.format("Writing %s", filename));
		 * Highgui.imwrite(filename, verif);
		 */
	}

	public static Mat bufferedImageToMat(BufferedImage bi) {
		Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
		byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
		mat.put(0, 0, data);
		return mat;
	}

}
