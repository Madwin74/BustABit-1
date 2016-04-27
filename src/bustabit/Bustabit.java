package bustabit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Bustabit extends JFrame {

	private JPanel contentPane;
	public static FirefoxDriver driver;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTextField textField_8;
	private static JTextField textField_9;
	private static JTextField textField_10;
	private static JTextField textField_11;
	private static JTextField textField_12;
	private static JTextField textField_13;
	private static JTextField textField_14;
	private static JTextField textField_15;
	private static JTextField textField_16;
	private static JTextField textField_17;
	private static JTextField textField_18;
	
	private static long valA=0;
	private static long valB=0;
	private static long valC=0;
	private static long valD=0;
	private static long valE=0;
	private static long valF=0;
	private static long valG=0;
	private static long valH=0;
	private static long valI=0;
	private static long valJ=0;
	private static long valK=0;
	private static long valL=0;
	private static long valM=0;
	private static long valN=0;
	private static long valO=0;
	private static long valP=0;
	private static long valQ=0;
	private static long valR=0;
	private static long valS=0;
	private static long baseBet;
	private static long maxBet;
	private static double stopProfit;
	private static double stopLoss;
	private static double multiplier;
	private static long nextBet;
	
	private static String cashoutnowS;
	private static double cashoutnowD;
	private static boolean wewin;
	
	private static WebElement button;
	
	private static boolean play = true;
	
	private static JTextField textField_19;
	private static JTextField textField_21;
	private static JTextField textField_24;
	private static JTextField textField_25;
	
	private static String usn;
	private static String pwd = "";
	private JPasswordField passwordField;
	private static boolean wwd = false;
	private static JLabel lblWrongCredentials;
	private static JButton btnStart;
	private static JButton btnStartBetting;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bustabit frame = new Bustabit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void execute(){
		lblWrongCredentials.setVisible(false);
		
		usn = textField_24.getText();
		pwd = textField_25.getText();
		
		
		if (pwd.length() < 6 || usn.length() < 1) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lblWrongCredentials.setVisible(true);
			return;
		}
		
		lblWrongCredentials.setVisible(false);
		btnStartBetting.setEnabled(true);
		
		FirefoxProfile profile = new FirefoxProfile();	
		FirefoxDriver ffdriver = new FirefoxDriver(profile);
		ffdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ffdriver.navigate().to("https://www.bustabit.com/login");
		
		setDriver(ffdriver);
		
		
		

			

		WebElement username = ffdriver.findElementByXPath("/html/body/div[1]/div/div/form/div[1]/div/label/input");
		WebElement password = ffdriver.findElementByXPath("/html/body/div[1]/div/div/form/div[2]/div/label/input");
		
		username.sendKeys(usn);
		password.sendKeys(pwd);
		
		
		WebElement frameswitch = driver.findElementByXPath("/html/body/div[1]/div/div/form/div[4]/div/div/div/iframe");
		ffdriver.switchTo().frame(frameswitch);	
	
		
		WebElement captcha = ffdriver.findElementByXPath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[5]");
		
		captcha.click();
		
		
		
	
	}
	
	public static void bet(FirefoxDriver driver) throws InterruptedException{
		
		
//		while (true) {
		
			
			button = driver.findElementByXPath("/html/body/div/div/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[3]/div/button");
			WebElement bet = driver.findElementByXPath("/html/body/div/div/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/input");
			WebElement cashout = driver.findElementByXPath("/html/body/div/div/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/input");
			
			WebElement bits = driver.findElementByXPath("/html/body/div/div/div[1]/div/div[1]/div[2]/div[1]/span[2]");
			
			
			System.out.println("Balance: " + bits.getText());
			
			nextBet = baseBet;
			
			String buttonText = getButtonText();
			
			int rounds = 1;
			
			while (play){
				
				if (wwd){
					button = driver.findElementByXPath("/html/body/div/div/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[3]/div/button");
					bet = driver.findElementByXPath("/html/body/div/div/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/input");
					cashout = driver.findElementByXPath("/html/body/div/div/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/input");
					wwd = false;
				}
				
				
				System.out.println("Round: " + rounds);
				
				Thread.sleep(1000);
				
				bet.clear();
				Thread.sleep(20);
				bet.sendKeys(Long.toString(nextBet));
				Thread.sleep(50);
				cashout.clear();
				Thread.sleep(50);
				cashout.sendKeys(NumberFormat.getNumberInstance(Locale.GERMAN).format(multiplier));
				Thread.sleep(20);
				
				
				System.out.println("Input: Bet: " + nextBet + "  |  cashout@ " + NumberFormat.getNumberInstance(Locale.GERMAN).format(multiplier));
			
				while (!getButtonText().contains("Place bet")){
					
					if (getButtonText().contains("too big")){
						bet.clear();
						Thread.sleep(20);
						bet.sendKeys(Long.toString(nextBet));
						Thread.sleep(50);
						cashout.clear();
						Thread.sleep(50);
						cashout.sendKeys(NumberFormat.getNumberInstance(Locale.GERMAN).format(multiplier));
						Thread.sleep(20);		
					}
					
					Thread.sleep(500);
				}
				
				button.click();
//				play = false;
				
				Thread.sleep(1000);
				
				while (getButtonText().contains("Betting")){
					Thread.sleep(100);
				}					
				while(getButtonText().contains("Cash out")){	
					String text = button.getText();
					if (text.length() > 14) {
						cashoutnowS = text.substring(11, text.length() - 4);
					}
					if (!cashoutnowS.isEmpty()){
						cashoutnowS = cashoutnowS.replace(",", "");
						cashoutnowD = Double.parseDouble(cashoutnowS);
					} else {
						cashoutnowD = 0;
					}
					if (cashoutnowD >= (multiplier*0.975) * nextBet) {					
						wewin = true;						
						break;
					} else {
						wewin = false;
					}
				} 	
				if (wewin) {
					nextBet = baseBet;
					System.out.println("You won!  |  last checkout: " + cashoutnowD);
				} else {
					nextBet = nextBet(nextBet);
					System.out.println("You lost!  |  latest checkout: " + cashoutnowD);
				}		
				rounds++;
				Thread.sleep(500);
				
				
				String sbits = bits.getText();
				String realbits = sbits.replace(",", "");
				Double drealbits = Double.parseDouble(realbits);
				
				
				if (drealbits > 500000 && pwd.length() > 5) {

					driver.navigate().to("https://www.bustabit.com/withdraw");					
					Thread.sleep(20);				
					WebElement wd = driver.findElementByXPath("/html/body/div/div/div/div/div[2]/a");
					wd.click();					
					Thread.sleep(20);					
					WebElement am = driver.findElementByXPath("/html/body/div[1]/div/div/div/div[2]/form/input[4]");
					WebElement adr = driver.findElementByXPath("/html/body/div[1]/div/div/div/div[2]/form/input[5]");
					WebElement pw = driver.findElementByXPath("/html/body/div[1]/div/div/div/div[2]/form/input[6]");
					WebElement wd2 = driver.findElementByXPath("/html/body/div[1]/div/div/div/div[2]/form/input[7]");				
					NumberFormat nf = new DecimalFormat("#");
					String send = nf.format(Math.round(drealbits*0.99));				
				 	am.sendKeys(send);
				 	Thread.sleep(5);
					adr.sendKeys("14WXJ8ZTWNkrYgcrsNsMRS3yG8oMcxaJmB");
					Thread.sleep(5);
					pw.sendKeys(pwd);	
					Thread.sleep(5);
					wd2.click();
					
					Thread.sleep(500);
					
					driver.navigate().to("https://www.bustabit.com/play");
					
					wwd = true;									
				}
				
				
				
				
			}
			
			
			
			
			

		
		
//		}
		
	}
	
	
	
	private static long nextBet(long prevBet) {

		if (prevBet == baseBet) {
			if (valA != 0){
				return valA;
			}			
			return baseBet;
		}
		if (prevBet == valA){
			if (valB!= 0){
				return valB;
			}	
			return baseBet;
		}
		if (prevBet == valB) {
			if (valC != 0){
				return valC;
			}	
			return baseBet;
		}
		if (prevBet == valC){
			if (valD != 0){
				return valD;
			}	
			return baseBet;
		}
		if (prevBet == valD) {
			if (valE != 0){
				return valE;
			}	
			return baseBet;
		}
		if (prevBet == valE){
			if (valF != 0){
				return valF;
			}	
			return baseBet;
		}
		if (prevBet == valF) {
			if (valG != 0){
				return valG;
			}	
			return baseBet;
		}
		if (prevBet == valG){
			if (valH != 0){
				return valH;
			}	
			return baseBet;
		}
		if (prevBet == valH) {
			if (valI != 0){
				return valI;
			}	
			return baseBet;
		}
		if (prevBet == valI){
			if (valJ != 0){
				return valJ;
			}
			return baseBet;
		}
		if (prevBet == valJ) {
			if (valK != 0){
				return valK;
			}	
			return baseBet;
		}
		if (prevBet == valK){
			if (valL != 0){
				return valL;
			}	
			return baseBet;
		}
		if (prevBet == valL) {
			if (valM != 0){
				return valM;
			}	
			return baseBet;
		}
		if (prevBet == valM){
			if (valN != 0){
				return valN;
			}	
			return baseBet;
		}
		if (prevBet == valN){
			if (valO != 0){
				return valO;
			}	
			return baseBet;
		}
		if (prevBet == valO){
			if (valP != 0){
				return valP;
			}	
			return baseBet;
		}
		if (prevBet == valP){
			if (valQ != 0){
				return valQ;
			}	
			return baseBet;
		}
		if (prevBet == valQ){
			if (valR != 0){
				return valR;
			}	
			return baseBet;
		}
		if (prevBet == valR){
			if (valS != 0){
				return valS;
			}	
			return baseBet;
		} 
		else {
			return 0;
		}		
	}

	/**
	 * Create the frame.
	 */
	public Bustabit() {
		setBackground(Color.GREEN);
		setTitle("BustaBit BOT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBasebet = new JLabel("Basebet: ");
		lblBasebet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBasebet.setBounds(10, 11, 69, 22);
		contentPane.add(lblBasebet);
		
		JLabel lblA = new JLabel("Multiplier: ");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblA.setBounds(10, 44, 69, 22);
		contentPane.add(lblA);
		
		JLabel lblOrder = new JLabel("Order: ");
		lblOrder.setBounds(10, 92, 46, 14);
		contentPane.add(lblOrder);
		
		JLabel lblA_1 = new JLabel("A: ");
		lblA_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblA_1.setBounds(10, 117, 46, 14);
		contentPane.add(lblA_1);
		
		JLabel lblE = new JLabel("E: ");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblE.setBounds(10, 142, 46, 14);
		contentPane.add(lblE);
		
		JLabel lblB = new JLabel("B:");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblB.setBounds(128, 117, 46, 14);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C: ");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblC.setBounds(255, 117, 46, 14);
		contentPane.add(lblC);
		
		JLabel lblD = new JLabel("D: ");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblD.setBounds(395, 117, 46, 14);
		contentPane.add(lblD);
		
		JLabel lblF = new JLabel("F: ");
		lblF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblF.setBounds(128, 142, 46, 14);
		contentPane.add(lblF);
		
		JLabel lblG = new JLabel("G: ");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblG.setBounds(255, 142, 46, 14);
		contentPane.add(lblG);
		
		JLabel lblH = new JLabel("H: ");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblH.setBounds(395, 142, 46, 14);
		contentPane.add(lblH);
		
		JLabel lblI = new JLabel("I: ");
		lblI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblI.setBounds(10, 167, 46, 14);
		contentPane.add(lblI);
		
		JLabel lblJ = new JLabel("J: ");
		lblJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJ.setBounds(128, 167, 46, 14);
		contentPane.add(lblJ);
		
		JLabel lblK = new JLabel("K: ");
		lblK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblK.setBounds(255, 167, 46, 14);
		contentPane.add(lblK);
		
		JLabel lblL = new JLabel("L: ");
		lblL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblL.setBounds(395, 167, 46, 14);
		contentPane.add(lblL);
		
		JLabel lblM = new JLabel("M:");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblM.setBounds(10, 192, 46, 14);
		contentPane.add(lblM);
		
		JLabel lblN = new JLabel("N: ");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblN.setBounds(128, 192, 46, 14);
		contentPane.add(lblN);
		
		JLabel lblO = new JLabel("O: ");
		lblO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblO.setBounds(255, 192, 46, 14);
		contentPane.add(lblO);
		
		JLabel lblP = new JLabel("P: ");
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblP.setBounds(395, 192, 46, 14);
		contentPane.add(lblP);
		
		JLabel lblQ = new JLabel("Q:");
		lblQ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQ.setBounds(10, 217, 46, 14);
		contentPane.add(lblQ);
		
		JLabel lblR = new JLabel("R: ");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblR.setBounds(128, 217, 46, 14);
		contentPane.add(lblR);
		
		JLabel lblS = new JLabel("S: ");
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblS.setBounds(255, 217, 46, 14);
		contentPane.add(lblS);
		
		
		
		
		

		
		btnStartBetting = new JButton("Start Betting");
		btnStartBetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					bet(driver);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnStartBetting.setBounds(219, 315, 148, 23);
		btnStartBetting.setEnabled(false);
		contentPane.add(btnStartBetting);
		
		
		
		btnStart = new JButton("Start Browser / Login");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				execute();	
				
				
			}
		});
		btnStart.setBounds(10, 315, 199, 23);
		contentPane.add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(32, 115, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 115, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(280, 115, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(418, 115, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(32, 140, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(153, 140, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(280, 140, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(418, 140, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(32, 165, 86, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(153, 165, 86, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(280, 165, 86, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(418, 165, 86, 20);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(32, 192, 86, 20);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(153, 192, 86, 20);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(280, 192, 86, 20);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(418, 192, 86, 20);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(32, 217, 86, 20);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(153, 217, 86, 20);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(280, 217, 86, 20);
		contentPane.add(textField_18);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				save();
				
			}
		});
		btnNewButton.setBounds(415, 217, 89, 22);
		contentPane.add(btnNewButton);
		
		textField_19 = new JTextField();
		textField_19.setBounds(64, 13, 86, 20);
		contentPane.add(textField_19);
		textField_19.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(64, 44, 37, 20);
		contentPane.add(textField_21);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 264, 69, 19);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 285, 69, 19);
		contentPane.add(lblPassword);
		
		textField_24 = new JTextField();
		textField_24.setBounds(76, 261, 133, 20);
		contentPane.add(textField_24);
		textField_24.setColumns(10);
		
//		textField_25 = new JTextField();
//		textField_25.setColumns(10);
//		textField_25.setBounds(90, 380, 133, 20);
//		contentPane.add(textField_25);
		
		textField_25 = new JPasswordField();
		textField_25.setBounds(76, 284, 133, 20);
		contentPane.add(textField_25);
		
		
		JButton btnStopBetting = new JButton("Stop Betting");
		btnStopBetting.setEnabled(false);
		btnStopBetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				play = false;				
			}
		});
		btnStopBetting.setBounds(375, 315, 107, 23);
		contentPane.add(btnStopBetting);
		
		JLabel lblEg = new JLabel("e.g. 1.5");
		lblEg.setBounds(111, 49, 46, 14);
		contentPane.add(lblEg);
		
		JLabel lblSetBasebet = new JLabel("1. Set Basebet, Multiplier and Order");
		lblSetBasebet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSetBasebet.setBounds(167, 17, 235, 22);
		contentPane.add(lblSetBasebet);
		
		JLabel lblClicksave = new JLabel("2. Click \"Save\"");
		lblClicksave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClicksave.setBounds(167, 30, 235, 22);
		contentPane.add(lblClicksave);
		
		JLabel lblTypeIn = new JLabel("3. Type in Usercredentials and click \"Start Browser / Login\"");
		lblTypeIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeIn.setBounds(167, 43, 357, 22);
		contentPane.add(lblTypeIn);
		
		JLabel lblGotoBustabit = new JLabel("4. Goto BustaBit standard play modus");
		lblGotoBustabit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGotoBustabit.setBounds(167, 56, 235, 22);
		contentPane.add(lblGotoBustabit);
		
		JLabel lblClickstart = new JLabel("5. Click \"Start Betting\", lean back and Profit");
		lblClickstart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClickstart.setBounds(167, 71, 274, 22);
		contentPane.add(lblClickstart);
		
		lblWrongCredentials = new JLabel("Wrong Credentials!");
		lblWrongCredentials.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWrongCredentials.setBounds(232, 264, 170, 41);
		lblWrongCredentials.setVisible(false);
		contentPane.add(lblWrongCredentials);
		

		
		
	}
	
	public static void save(){
		
		if (!textField.getText().isEmpty()){	
			valA = Long.parseLong(textField.getText());
		}
		if (!textField_1.getText().isEmpty()){	
			valB = Long.parseLong(textField_1.getText());
		}
		if (!textField_2.getText().isEmpty()){	
			valC = Long.parseLong(textField_2.getText());
		}
		if (!textField_3.getText().isEmpty()){	
			valD = Long.parseLong(textField_3.getText());
		}
		if (!textField_4.getText().isEmpty()){	
			valE = Long.parseLong(textField_4.getText());
		}
		if (!textField_5.getText().isEmpty()){	
			valF = Long.parseLong(textField_5.getText());
		}
		if (!textField_6.getText().isEmpty()){	
			valG = Long.parseLong(textField_6.getText());
		}
		if (!textField_7.getText().isEmpty()){	
			valH = Long.parseLong(textField_7.getText());
		}
		if (!textField_8.getText().isEmpty()){	
			valI = Long.parseLong(textField_8.getText());
		}
		if (!textField_9.getText().isEmpty()){	
			valJ = Long.parseLong(textField_9.getText());
		}
		if (!textField_10.getText().isEmpty()){	
			valK = Long.parseLong(textField_10.getText());
		}
		if (!textField_11.getText().isEmpty()){	
			valL = Long.parseLong(textField_11.getText());
		}
		if (!textField_12.getText().isEmpty()){	
			valM = Long.parseLong(textField_12.getText());
		}
		if (!textField_13.getText().isEmpty()){	
			valN = Long.parseLong(textField_13.getText());
		}
		if (!textField_14.getText().isEmpty()){	
			valO = Long.parseLong(textField_14.getText());
		}
		if (!textField_15.getText().isEmpty()){	
			valP = Long.parseLong(textField_15.getText());
		}
		if (!textField_16.getText().isEmpty()){	
			valQ = Long.parseLong(textField_16.getText());
		}
		if (!textField_17.getText().isEmpty()){	
			valR = Long.parseLong(textField_17.getText());
		}
		if (!textField_18.getText().isEmpty()){	
			valS = Long.parseLong(textField_18.getText());
		}
		
		
		if (!textField_19.getText().isEmpty()){	
			baseBet = Long.parseLong(textField_19.getText());
			System.out.println("basebet: " + baseBet);
		}
		if (!textField_21.getText().isEmpty()){	
			multiplier = Double.parseDouble(textField_21.getText());
			System.out.println("multiplier: " + NumberFormat.getNumberInstance(Locale.GERMAN).format(multiplier));
		}


		
		
	}
	
	public static void setDriver(FirefoxDriver driver1) {
		driver = driver1;
	}
	public static FirefoxDriver getDriver (){
		return driver;
	}
	public static String getButtonText(){
		return button.getText();
	}
}
