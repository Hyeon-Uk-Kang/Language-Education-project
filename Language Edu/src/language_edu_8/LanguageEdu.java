package language_edu_8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.xdevapi.Table;

public class LanguageEdu extends JFrame {

	protected SignDataManagement login = new SignDataManagement();
	protected OwnVoca userVoca = new OwnVoca();
	protected LanguageDB languageDB = new LanguageDB();
	
	
	private String currentUser; // OwnVoca 를 위한 현재 사용자의 닉네임 저장

	JOptionPane a = new JOptionPane();
	private Image screenImage;
	private Graphics screenGraphic;
	private Music introMusic = new Music("introMusic.mp3", true);

	private Image Background = new ImageIcon(Main.class.getResource("../images/Background.jpg")).getImage();
	private Image signUpBackground = new ImageIcon(Main.class.getResource("../images/Background.jpg")).getImage();

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.jpg")));

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 이미지 선언 파트
	 */

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon signUpButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/signUpButtonEntered.png"));
	private ImageIcon signUpButtonBasicImage = new ImageIcon(Main.class.getResource("../images/signUpButtonBasic.png"));
	private ImageIcon signInButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/signInButtonEntered.png"));
	private ImageIcon signInButtonBasicImage = new ImageIcon(Main.class.getResource("../images/signInButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon koreanButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/koreanButtonEntered.png"));
	private ImageIcon koreanButtonBasicImage = new ImageIcon(Main.class.getResource("../images/koreanButtonBasic.png"));
	private ImageIcon englishButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/englishButtonEntered.png"));
	private ImageIcon englishButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/englishButtonBasic.png"));
	private ImageIcon chineseButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/chineseButtonEntered.png"));
	private ImageIcon chineseButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/chineseButtonBasic.png"));
	private ImageIcon continueButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/continueButtonEntered.png"));
	private ImageIcon continueButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/continueButtonBasic.png"));
	private ImageIcon ownVocaButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/ownVocaButtonBasic.png"));
	private ImageIcon ownVocaButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/ownVocaButtonEntered.png"));
	private ImageIcon addButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/addButtonBasic.png"));
	private ImageIcon addButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/addButtonEntered.png"));
	private ImageIcon deleteButtonBasicImage = new ImageIcon(
			Main.class.getResource("../images/deleteButtonBasic.png"));
	private ImageIcon deleteButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/deleteButtonEntered.png"));
	private ImageIcon level1ButtonBasicImage = new ImageIcon(Main.class.getResource("../images/level1Button.png"));
	private ImageIcon level1ButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/level1ButtonEntered.png"));
	private ImageIcon level2ButtonBasicImage = new ImageIcon(Main.class.getResource("../images/level2Button.png"));
	private ImageIcon level2ButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/level2ButtonEntered.png"));
	private ImageIcon testButtonBasicImage = new ImageIcon(Main.class.getResource("../images/testButton.png"));
	private ImageIcon testButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/testButtonEntered.png"));
	private ImageIcon submitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/submitButtonBasic.png"));
	private ImageIcon submitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/submitButtonEntered.png"));
	
	
	
	

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton signUpButton = new JButton(signUpButtonBasicImage);
	private JButton signInButton = new JButton(signInButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	private JButton koreanButton = new JButton(koreanButtonBasicImage);
	private JButton englishButton = new JButton(englishButtonBasicImage);
	private JButton chineseButton = new JButton(chineseButtonBasicImage);
	private JButton continueButton = new JButton(continueButtonBasicImage);
	private JButton ownVocaButton = new JButton(ownVocaButtonBasicImage);
	private JButton addButton = new JButton(addButtonBasicImage);
	private JButton deleteButton = new JButton(deleteButtonBasicImage);
	private JButton level1Button = new JButton(level1ButtonBasicImage);
	private JButton level2Button = new JButton(level2ButtonBasicImage);
	private JButton testButton = new JButton(testButtonBasicImage);
	private JButton submitButton = new JButton(submitButtonBasicImage);

	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 *  입력 받고 쓸 수 있는 TEXT 객체 선언 파트
	 */
	private JTextField idField = new JTextField(15);
	private JPasswordField pwField = new JPasswordField(15);
	
	private JTextField idFieldup = new JTextField(15);
	private JPasswordField passwordFieldup = new JPasswordField(15);
	private JTextField NicknameFieldup = new JTextField(15);
	
	private JTextField ownWordField = new JTextField(15);
	private JTextField ownMeanField = new JTextField(30);
	
	private JTextField answerField = new JTextField(30);
	private JTextField questionField = new JTextField(200);
	
	private boolean isOwn = false;
	private boolean islevel2 = false;
	private boolean islevel1 = false;
	
	/////////////////////////////// myVoca Table //////////////////////
	private int num;
	private int randomIndex; // 랜덤한 i 정의 
	private  Random ran = new Random();
	private String question; 
	
	
	private JTable ownVocaTable;
	private JScrollPane ownVocaList;	
	private DefaultTableModel model;
	private int rowIndex;
	private int columnIndex;
	
	private Vector<String> userColumn = new Vector<String>();
	
	private Vector<String> LangColumn = new Vector<String>();
	private JTable LanguageTable;
	private JScrollPane LanguageList;	
	private DefaultTableModel LanguageModel;

	
	
	
	/*
	 * 각 화면 별 boolean 값
	 */
	private boolean isMainScreen = false;
	private boolean isNextMainScreen = false;
	private boolean isLevelSelectScreen = false;
	private boolean isLevelScreen = false;
	private boolean isTest = false;
	private boolean isEnglish = false;
	private boolean isKorean = false;
	private boolean isChinese = false;
	
	
	
	private int mouseX, mouseY;
//////////////////////////////// Language Edu 시작 ////////////////////////////////
	public LanguageEdu() {
		introMusic.start(); // intro 배경음악 삽입
		isMainScreen = true; // 바탕화면
		
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		
		
		
		//////////////////// TextField //////////////////////////
		idFieldup.setBounds(500, 242, 300, 35);
		idFieldup.setFont(new Font("",Font.BOLD,20));
		add(idFieldup);
		idFieldup.setVisible(false);

		passwordFieldup.setBounds(500, 350, 300, 35);
		passwordFieldup.setFont(new Font("", Font.BOLD, 20));
		add(passwordFieldup);
		passwordFieldup.setVisible(false);

		NicknameFieldup.setBounds(500, 460, 300, 35);
		NicknameFieldup.setFont(new Font("", Font.BOLD, 20));
		add(NicknameFieldup);
		NicknameFieldup.setVisible(false);

		pwField.setBounds(145, 390, 300, 35);
		pwField.setFont(new Font("", Font.BOLD, 20));
		pwField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					String InId = idField.getText();
					String InPw = "";
					char[] pw = pwField.getPassword();
					for (char cha : pw) {
						Character.toString(cha);
						InPw += (InPw.equals("")) ? "" + cha + "" : "" + cha + "";
					}

					// database에서 찾아야함 못찾을 시 false 찾을 시 true 반환
					boolean islog = login.isLogIn(InId, InPw);

					if (islog == true) {
						// 로그인 화면으로 전환
						signUpButton.setVisible(false);
						signInButton.setVisible(false);
						idField.setVisible(false);
						pwField.setVisible(false);
						backButton.setVisible(true);
						koreanButton.setVisible(true);
						englishButton.setVisible(true);
						chineseButton.setVisible(true);
						Background = new ImageIcon(Main.class.getResource("../images/signInBackground.jpg")).getImage();
						isNextMainScreen = true;
						isMainScreen = false;
						pwField.setText("");
						idField.setText("");
						currentUser = login.getNickname(InId);
					} else {
						a.showMessageDialog(null, "아이디와 패스워드가 불일치 합니다.");
						pwField.setText("");
						idField.setText("");
						idField.requestFocus();
					}
				}
			}
		});
		add(pwField);
		pwField.setVisible(true);

		idField.setBounds(145, 290, 300, 35);
		idField.setFont(new Font("",Font.BOLD,20));
		add(idField);
		idField.setVisible(true);

		
		ownWordField.setBounds(370, 150, 125, 35);
		ownWordField.setFont(new Font("",Font.BOLD,20));
		add(ownWordField);
		ownWordField.setVisible(false);
		
		ownMeanField.setBounds(515, 150, 390, 35);
		ownMeanField.setFont(new Font("",Font.BOLD,20));
		add(ownMeanField);
		ownMeanField.setVisible(false);
	
		
		
		userColumn.addElement("Word");
		userColumn.addElement("Mean");
		
		model = new DefaultTableModel(userColumn,0);
		
		ownVocaTable = new JTable(model);
		ownVocaList = new JScrollPane(ownVocaTable);
		ownVocaList.setBounds(400, 200, 500, 400);
		ownVocaTable.getColumn("Word").setPreferredWidth(100);
		ownVocaTable.getColumn("Mean").setPreferredWidth(400);
		add(ownVocaList);
		ownVocaList.setVisible(false);
		
		
		
		LangColumn.addElement("Word");
		LangColumn.addElement("Mean");
		LangColumn.addElement("Sentence");
		
		LanguageModel = new DefaultTableModel(LangColumn,0);
		
		LanguageTable = new JTable(LanguageModel);
		LanguageList = new JScrollPane(LanguageTable);
		add(LanguageList);
		LanguageList.setVisible(false);
		
		
		
		questionField.setBounds(150, 250, 1000, 40);
		questionField.setFont(new Font("",Font.BOLD,25));
		add(questionField);
		questionField.setVisible(false);
		
		answerField.setBounds(550, 350, 150, 40);
		answerField.setFont(new Font("",Font.BOLD,27));
		add(answerField);
		answerField.setVisible(false);
		
		
		//////////////////////// Button ///////////////////////////////
		continueButton.setVisible(false);
		chineseButton.setVisible(false);
		koreanButton.setVisible(false);
		englishButton.setVisible(false);
		level1Button.setVisible(false);
		level2Button.setVisible(false);
		testButton.setVisible(false);
		
		
		
		exitButton.setBounds(1250, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);

		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/*
				 * exit button 누를 시 사용 종료
				 */
				System.exit(0);
			}
		});
		add(exitButton);

		signUpButton.setBounds(50, 580, 213, 62);
		signUpButton.setBorderPainted(false);
		signUpButton.setContentAreaFilled(false);
		signUpButton.setFocusPainted(false);
		signUpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signUpButton.setIcon(signUpButtonEnteredImage);
				signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signUpButton.setIcon(signUpButtonBasicImage);
				signUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/*
				 * 회원가입 화면으로 전환 후 회원가입 절차 진행
				 */
				signUpButton.setVisible(false);
				signInButton.setVisible(false);
				idField.setVisible(false);
				pwField.setVisible(false);
				idFieldup.setVisible(true);
				passwordFieldup.setVisible(true);
				NicknameFieldup.setVisible(true);
				backButton.setVisible(true);
				continueButton.setVisible(true);
				Background = new ImageIcon(Main.class.getResource("../images/signUpBackground.jpg")).getImage();
				isNextMainScreen = true;
				isMainScreen = false;
			}
		});
		add(signUpButton);

		signInButton.setBounds(50, 490, 213, 62);
		signInButton.setBorderPainted(false);
		signInButton.setContentAreaFilled(false);
		signInButton.setFocusPainted(false);
		signInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signInButton.setIcon(signInButtonEnteredImage);
				signInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signInButton.setIcon(signInButtonBasicImage);
				signInButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				String InId = idField.getText();
				String InPw = "";
				char[] pw = pwField.getPassword();
				for (char cha : pw) {
					Character.toString(cha);
					InPw += (InPw.equals("")) ? "" + cha + "" : "" + cha + "";
				}

				// database에서 찾아야함 못찾을 시 false 찾을 시 true 반환
				boolean islog = login.isLogIn(InId, InPw);

				if (islog == true) {
					// 로그인 화면으로 전환
					signUpButton.setVisible(false);
					signInButton.setVisible(false);
					idField.setVisible(false);
					pwField.setVisible(false);
					backButton.setVisible(true);
					koreanButton.setVisible(true);
					englishButton.setVisible(true);
					chineseButton.setVisible(true);
					Background = new ImageIcon(Main.class.getResource("../images/signInBackground.jpg")).getImage();
					isNextMainScreen = true;
					isMainScreen = false;
					pwField.setText("");
					idField.setText("");
					currentUser = login.getNickname(InId); // 현재 사용중인 사용자 닉네임 받아오기
					System.out.println(": "+currentUser);
				} else {
					a.showMessageDialog(null, "아이디와 패스워드가 불일치 합니다.");
					pwField.setText("");
					idField.setText("");
					idField.requestFocus();

				}

			}
		});
		add(signInButton);

		backButton.setVisible(false);
		backButton.setBounds(10, 30, 50, 50);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/*
				 * 각 isScreen 별 true 일 때 그 뒤의 화면으로 전환 해 줄 수 있도록 구현
				 */
				if (isNextMainScreen == true || isNextMainScreen == true || isNextMainScreen == true)
					backMain();
				else if (isLevelSelectScreen == true)
					backLanSelection();
				else if (isLevelScreen = true)
					backLevelSelection();

			}
		});
		add(backButton);

		englishButton.setBounds(200, 300, 213, 62);
		englishButton.setBorderPainted(false);
		englishButton.setContentAreaFilled(false);
		englishButton.setFocusPainted(false);
		englishButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				englishButton.setIcon(englishButtonEnteredImage);
				englishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				englishButton.setIcon(englishButtonBasicImage);
				englishButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				Background = new ImageIcon(Main.class.getResource("../images/englishBackground.jpg")).getImage();
				englishButton.setVisible(false);
				koreanButton.setVisible(false);
				chineseButton.setVisible(false);
				level1Button.setVisible(true);
				level2Button.setVisible(true);
				testButton.setVisible(true);
				ownVocaButton.setVisible(true);
				
				
				isLevelSelectScreen = true;
				isNextMainScreen = false;
				isEnglish = true;

				
				
				languageDB.getLangList("English",LanguageModel);
				
			}
		});
		add(englishButton);

		koreanButton.setBounds(530, 300, 213, 62);
		koreanButton.setBorderPainted(false);
		koreanButton.setContentAreaFilled(false);
		koreanButton.setFocusPainted(false);
		koreanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				koreanButton.setIcon(koreanButtonEnteredImage);
				koreanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				koreanButton.setIcon(koreanButtonBasicImage);
				koreanButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Background = new ImageIcon(Main.class.getResource("../images/koreanBackground.jpg")).getImage();
				
				englishButton.setVisible(false);
				koreanButton.setVisible(false);
				chineseButton.setVisible(false);
				level1Button.setVisible(true);
				level2Button.setVisible(true);
				testButton.setVisible(true);
				ownVocaButton.setVisible(true);
				
				isLevelSelectScreen = true;
				isNextMainScreen = false;
				isKorean=true;
				
				languageDB.getLangList("Korean",LanguageModel);

			}
		});
		add(koreanButton);

		chineseButton.setBounds(860, 300, 213, 62);
		chineseButton.setBorderPainted(false);
		chineseButton.setContentAreaFilled(false);
		chineseButton.setFocusPainted(false);
		chineseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				chineseButton.setIcon(chineseButtonEnteredImage);
				chineseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				chineseButton.setIcon(chineseButtonBasicImage);
				chineseButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} 

			@Override
			public void mousePressed(MouseEvent e) {
				/*
				 * 중국어 DB 실행 & 배경 전환
				 */
				Background = new ImageIcon(Main.class.getResource("../images/chineseBackground.jpg")).getImage();
				englishButton.setVisible(false);
				koreanButton.setVisible(false);
				chineseButton.setVisible(false);
				level1Button.setVisible(true);
				level2Button.setVisible(true);
				testButton.setVisible(true);
				ownVocaButton.setVisible(true);
				
				isLevelSelectScreen = true;
				isNextMainScreen = false;
				isChinese=true;
				
				languageDB.getLangList("Chinese",LanguageModel);
				
			}
		});
		add(chineseButton);

		continueButton.setBounds(550, 600, 213, 62);
		continueButton.setBorderPainted(false);
		continueButton.setContentAreaFilled(false);
		continueButton.setFocusPainted(false);
		continueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				continueButton.setIcon(continueButtonEnteredImage);
				continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				continueButton.setIcon(continueButtonBasicImage);
				continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/* 회원가입창 입력후 continue 버튼 누를 때 파일에 입력한다 */

				String UpId;
				String UpPw;

				UpId = idFieldup.getText();
				UpPw = "";

				char[] pw = passwordFieldup.getPassword();
				for (char cha : pw) {
					Character.toString(cha);
					UpPw += (UpPw.equals("")) ? "" + cha + "" : "" + cha + "";
				}
				String UpNick = NicknameFieldup.getText();

				if (UpId.equals("") || UpPw.equals("") || UpNick.equals("")) {
					a.showMessageDialog(null, "모두 입력해 주세요.");
				} else {
					if (login.SignUp(UpId, UpPw, UpNick) == true) {

						userVoca.makeOwnVoca(UpNick);

						idFieldup.setText("");
						passwordFieldup.setText("");
						NicknameFieldup.setText("");
						backMain();
					} else {
						a.showMessageDialog(null, "해당 아이디 또는 닉네임이 이미 존재합니다.");
						idFieldup.setText("");
						passwordFieldup.setText("");
						NicknameFieldup.setText("");
						idFieldup.requestFocus();
					}
				}
			}
		});
		add(continueButton);

		
		level1Button.setBounds(200, 200, 213, 62);
		level1Button.setBorderPainted(false);
		level1Button.setContentAreaFilled(false);
		level1Button.setFocusPainted(false);
		level1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				level1Button.setIcon(level1ButtonEnteredImage);
				level1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				level1Button.setIcon(level1ButtonBasicImage);
				level1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				englishButton.setVisible(false);
				koreanButton.setVisible(false);
				chineseButton.setVisible(false);
				level1Button.setVisible(false);
				level2Button.setVisible(false);
				ownVocaButton.setVisible(false);
				testButton.setVisible(false);
				questionField.setVisible(true);
				answerField.setVisible(true);
				submitButton.setVisible(true);
				
				islevel1 = true;
				isLevelSelectScreen = false;
				isLevelScreen = true;
				
				num = LanguageTable.getRowCount();
				randomIndex=ran.nextInt(num)+0;			
				questionField.setText((String)LanguageModel.getValueAt(randomIndex, 1));
			}
		});
		add(level1Button);
		
		
		level2Button.setBounds(600, 200, 213, 62);
		level2Button.setBorderPainted(false);
		level2Button.setContentAreaFilled(false);
		level2Button.setFocusPainted(false);
		level2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				level2Button.setIcon(level2ButtonEnteredImage);
				level2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				level2Button.setIcon(level2ButtonBasicImage);
				level2Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				englishButton.setVisible(false);
				koreanButton.setVisible(false);
				chineseButton.setVisible(false);
				isLevelSelectScreen = false;
				isLevelScreen = true;
				isEnglish = true;
				islevel2=true;
				level1Button.setVisible(false);
				level2Button.setVisible(false);
				ownVocaButton.setVisible(false);
				testButton.setVisible(false);
				submitButton.setVisible(true);
				questionField.setVisible(true);
				answerField.setVisible(true);
				
				
				num = LanguageTable.getRowCount();
				randomIndex=ran.nextInt(num)+0;			
				questionField.setText((String)LanguageModel.getValueAt(randomIndex, 2));
			}
		});
		add(level2Button);
		
		
		

		testButton.setBounds(600, 400, 213, 62);
		testButton.setBorderPainted(false);
		testButton.setContentAreaFilled(false);
		testButton.setFocusPainted(false);
		testButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				testButton.setIcon(testButtonEnteredImage);
				testButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				testButton.setIcon(testButtonBasicImage);
				testButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				englishButton.setVisible(false);
				koreanButton.setVisible(false);
				chineseButton.setVisible(false);
				isLevelSelectScreen = false;
				isLevelScreen = true;
				isEnglish = true;
				level1Button.setVisible(false);
				level2Button.setVisible(false);
				ownVocaButton.setVisible(false);
				testButton.setVisible(false);
				submitButton.setVisible(true);
				questionField.setVisible(true);
				answerField.setVisible(true);
				isOwn = true;
				
				
				userVoca.getOwnVoca(currentUser,model);
				num = ownVocaTable.getRowCount();
				
				randomIndex = ran.nextInt(num)+0;
				question = (String)ownVocaTable.getValueAt(randomIndex, 1);
				questionField.setText(question);
				
				
			}
		});
		add(testButton);
		
		
		
		
		ownVocaButton.setBounds(200, 400, 213, 62);
		ownVocaButton.setBorderPainted(false);
		ownVocaButton.setContentAreaFilled(false);
		ownVocaButton.setFocusPainted(false);
		ownVocaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ownVocaButton.setIcon(ownVocaButtonEnteredImage);
				ownVocaButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ownVocaButton.setIcon(ownVocaButtonBasicImage);
				ownVocaButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				level1Button.setVisible(false);
				level2Button.setVisible(false);
				testButton.setVisible(false);
				ownVocaButton.setVisible(false);
				addButton.setVisible(true);
				deleteButton.setVisible(true);
				ownWordField.setVisible(true);
				ownMeanField.setVisible(true);
				
				
				userVoca.getOwnVoca(currentUser,model);
				
				ownVocaList.setVisible(true);
				isLevelSelectScreen = false;
				isLevelScreen = true;
				/*
				 *  로그인 되있는 사용자 ownVoca table 불러와서 Vector에 저장
				 */
				
			}
		});
		add(ownVocaButton);
		ownVocaButton.setVisible(false);

		
		
		
		addButton.setBounds(100, 250, 213, 62);
		addButton.setBorderPainted(false);
		addButton.setContentAreaFilled(false);
		addButton.setFocusPainted(false);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				addButton.setIcon(addButtonEnteredImage);
				addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				addButton.setIcon(addButtonBasicImage);
				addButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				if(ownWordField.getText().equals("")&&ownMeanField.getText().equals(""))
					a.showMessageDialog(null, "단어와 의미를 모두 입력해 주세요");
				else {
					userVoca.addOwnVoca(currentUser, ownWordField.getText(),ownMeanField.getText(),model);
					ownWordField.setText("");
					ownMeanField.setText("");
					
				}
			}
		});
		add(addButton);
		addButton.setVisible(false);
		
		
		deleteButton.setBounds(100, 350, 213, 62);
		deleteButton.setBorderPainted(false);
		deleteButton.setContentAreaFilled(false);
		deleteButton.setFocusPainted(false);
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteButton.setIcon(deleteButtonEnteredImage);
				deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				deleteButton.setIcon(deleteButtonBasicImage);
				deleteButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				rowIndex = ownVocaTable.getSelectedRow();
				columnIndex = ownVocaTable.getSelectedColumn();
				userVoca.deleteOwnVoca(currentUser, model,rowIndex,0);
				model = (DefaultTableModel)ownVocaTable.getModel();
				model.removeRow(rowIndex);
			}
		});
		add(deleteButton);
		deleteButton.setVisible(false);
		
		
		
		
		submitButton.setBounds(530, 500, 213, 62);
		submitButton.setBorderPainted(false);
		submitButton.setContentAreaFilled(false);
		submitButton.setFocusPainted(false);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				submitButton.setIcon(submitButtonEnteredImage);
				submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				submitButton.setIcon(submitButtonBasicImage);
				submitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(isOwn==true) { // ownVoca test 일때 명령
					if(answerField.getText().equals(""))
						a.showMessageDialog(null, "정답을 입력해 주세요");
					else if(!answerField.getText().equals(ownVocaTable.getValueAt(randomIndex, 0))){
						a.showMessageDialog(null, "오답 입니다\n 정답은 : "+ ownVocaTable.getValueAt(randomIndex, 0));
						randomIndex = ran.nextInt(num)+0;
						question = (String)ownVocaTable.getValueAt(randomIndex, 1);
						questionField.setText(question);
						answerField.setText("");
					}
					else {
						a.showMessageDialog(null, "정답입니다!!");
						randomIndex = ran.nextInt(num)+0;
						question = (String)ownVocaTable.getValueAt(randomIndex, 1);
						questionField.setText(question);
						answerField.setText("");
					}
				}
				else if(islevel2 == true) { // level2 일 때 명령
					if(answerField.getText().equals(""))
						a.showMessageDialog(null, "Please answer");
					else if(!answerField.getText().equals(LanguageTable.getValueAt(randomIndex, 0))){
						a.showMessageDialog(null, "Sorry! Wrong Answer\nANSWER : "+ LanguageTable.getValueAt(randomIndex, 0) + "\nMEAN : "+ LanguageTable.getValueAt(randomIndex, 1));
						randomIndex = ran.nextInt(num)+0;
						question = (String)LanguageTable.getValueAt(randomIndex,2);
						questionField.setText(question);
						answerField.setText("");
					}
					else {
						a.showMessageDialog(null, "Congratulation!!\n   Correct!");
						randomIndex = ran.nextInt(num)+0;
						question = (String)LanguageTable.getValueAt(randomIndex,2);
						questionField.setText(question);
						answerField.setText("");
					}
				}
				else {
					if(answerField.getText().equals(""))
						a.showMessageDialog(null, "Please answer");
					else if(!answerField.getText().equals(LanguageTable.getValueAt(randomIndex, 0))){
						a.showMessageDialog(null, "Sorry! Wrong Answer\nANSWER : "+ LanguageTable.getValueAt(randomIndex, 0));
						randomIndex = ran.nextInt(num)+0;
						question = (String)LanguageTable.getValueAt(randomIndex,1);
						questionField.setText(question);
						answerField.setText("");
					}
					else {
						a.showMessageDialog(null, "Congratulation!!\n   Correct!");
						randomIndex = ran.nextInt(num)+0;
						question = (String)LanguageTable.getValueAt(randomIndex,1);
						questionField.setText(question);
						answerField.setText("");
					}
				}
			}
		});
		add(submitButton);
		submitButton.setVisible(false);

		/*
		 * 위에 잡히는 바 구현
		 */

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();

			}
		});

		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

	public void backMain() {
		// 메인화면으로 돌아가는 메소드
		isMainScreen = true;
		isNextMainScreen = false;
		isNextMainScreen = false;
		backButton.setVisible(false);
		koreanButton.setVisible(false);
		englishButton.setVisible(false);
		chineseButton.setVisible(false);
		continueButton.setVisible(false);
		signInButton.setVisible(true);
		signUpButton.setVisible(true);
		idFieldup.setVisible(false);
		passwordFieldup.setVisible(false);
		NicknameFieldup.setVisible(false);
		idField.setVisible(true);
		pwField.setVisible(true);
		model.setNumRows(0);
		Background = new ImageIcon(Main.class.getResource("../images/Background.jpg")).getImage();
	}

	public void backLanSelection() {
		signUpButton.setVisible(false);
		signInButton.setVisible(false);
		idField.setVisible(false);
		pwField.setVisible(false);
		backButton.setVisible(true);
		koreanButton.setVisible(true);
		englishButton.setVisible(true);
		chineseButton.setVisible(true);
		level1Button.setVisible(false);
		level2Button.setVisible(false);
		testButton.setVisible(false);
		ownVocaButton.setVisible(false);
		LanguageModel.setNumRows(0);
		Background = new ImageIcon(Main.class.getResource("../images/signInBackground.jpg")).getImage();
		isNextMainScreen=true;
		isMainScreen = false;
		// 언어 선택창으로 back
	}

	public void backLevelSelection() {
		// 레벨 선택창으로 back
		ownVocaButton.setVisible(true);
		addButton.setVisible(false);
		deleteButton.setVisible(false);
		ownWordField.setVisible(false);
		ownMeanField.setVisible(false);
		ownVocaList.setVisible(false);
		submitButton.setVisible(false);
		level1Button.setVisible(true);
		level2Button.setVisible(true);
		testButton.setVisible(true);
		ownVocaButton.setVisible(true);
		questionField.setVisible(false);
		answerField.setVisible(false);
		
		isOwn = false;
		islevel2 = false;
		isLevelScreen = false;
		isEnglish=false;
		isKorean=false;
		isChinese=false;
		isLevelSelectScreen = true;
		answerField.setText("");
		model.setNumRows(0);
		
	}

}