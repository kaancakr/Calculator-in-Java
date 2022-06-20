package hesapMakinesi;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class hesapMakinesi {

	private JFrame frame;
	private JTextField txtsayi1;
	private JTextField txtsayi2;
	private JTextField txtSonuc;
	static int rakam = 0;
	static int rakam2 = 0;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hesapMakinesi window = new hesapMakinesi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});


	}

	//İngilizce sonuç ekranına yazdırılacak olan string ifadenin üretilişi için kullanılan diziler.
    String[] ones = new String[]{"","one","two","three","four","five","six","seven","eight","nine"};
    String[] tens = new String[]{"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
    String[] hundreds = new String[]{"","hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred","nine hundred"};
	int hundredsOfThousandsDigit = rakam2%1000000/100000;
	int tensOfThousands = rakam2%100000/10000;
	int thousandsPlace = rakam2%10000/1000;
	int hundredsDigit = rakam2%1000/100;
	int tensDigit = rakam2%100/10;
	int onesDigit = rakam2%10;
	String result2 = hundreds[hundredsOfThousandsDigit]+tens[tensOfThousands]+ones[thousandsPlace];{
		if(rakam2>999) result2 = result2 + "thousand";
		result2 = result2 + hundreds[hundredsDigit]+tens[tensDigit]+ones[onesDigit];{
			
		}
	}
	
    
	//Türkçe sonuç ekranına yazdırılacak olan string ifadenin üretilişi için kullanılan diziler.
    String[] birler = new String[]{"","bir","iki","üç","dört","beş","altı","yedi","sekiz","dokuz"};
	String[] onlar = new String[]{"","on","yirmi","otuz","kırk","elli","altmış","yetmiş","seksen","doksan"};
	String[] yuzler = new String[]{"","yüz","iki yüz","üç yüz","dört yüz","beş yüz","altı yüz","yedi yüz","sekiz yüz","dokuz yüz"};
	int yuzbinlerBasamagi =  rakam%1000000/100000;
	int onbinlerBasamagi =  rakam%100000/10000;
	int binlerBasamagi = rakam%10000/1000;
	int yuzlerBasamagi = rakam%1000/100;
	int onlarBasamagi = rakam%100/10;
	int birlerBasamagi = rakam%10;
	String result = yuzler[yuzbinlerBasamagi]+onlar[onbinlerBasamagi]+birler[binlerBasamagi];{
		if(rakam>999) result = result + "bin";
		result = result + yuzler[yuzlerBasamagi]+onlar[onlarBasamagi]+birler[birlerBasamagi];{
		}
	}

	public hesapMakinesi() {
		initialize();
	}

	//Kullandığım panelin görüntüsünü ve işlevlerini ayarladığım JFrame kodları.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSayiyiGiriniz = new JLabel("Birinci Sayı :");
		lblSayiyiGiriniz.setBounds(10, 11, 157, 23);
		lblSayiyiGiriniz.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		frame.getContentPane().add(lblSayiyiGiriniz);

		JLabel lblNewLabel = new JLabel("İkinci Sayı :");
		lblNewLabel.setBounds(10, 45, 132, 23);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);

		txtsayi1 = new JTextField();
		txtsayi1.setBackground(Color.LIGHT_GRAY);
		txtsayi1.setBounds(179, 12, 215, 23);
		frame.getContentPane().add(txtsayi1);
		txtsayi1.setColumns(10);


		txtsayi2 = new JTextField();
		txtsayi2.setBackground(Color.LIGHT_GRAY);
		txtsayi2.setBounds(179, 45, 215, 23);
		frame.getContentPane().add(txtsayi2);
		txtsayi2.setColumns(10);

		//Toplama işlemi butonunun tasarımı ve işlevselliğinin ayarlanmasını sağlayan kodlar.
		JButton btnToplama = new JButton("Topla");
		btnToplama.setBounds(10, 157, 89, 23);
		btnToplama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				int sayi1=(int) Double.parseDouble(txtsayi1.getText());
				int sayi2=(int) Double.parseDouble(txtsayi2.getText());
				int sonuc= sayi1+sayi2;
				rakam = sonuc;
				int yuzbinlerBasamagi =  rakam%1000000/100000;
				int onbinlerBasamagi =  rakam%100000/10000;
				int binlerBasamagi = rakam%10000/1000;
				int yuzlerBasamagi = rakam%1000/100;
				int onlarBasamagi = rakam%100/10;
				int birlerBasamagi = rakam%10;
				String result = yuzler[yuzbinlerBasamagi]+onlar[onbinlerBasamagi]+birler[binlerBasamagi];{
					if(rakam>999) result = result + "bin";
					result = result + yuzler[yuzlerBasamagi]+onlar[onlarBasamagi]+birler[birlerBasamagi];{
					}
				}
				txtSonuc.setText(String.valueOf(result));


			}
		});
		frame.getContentPane().add(btnToplama);


		//Çıkarma işlemi butonunun tasarımı ve işlevselliğinin ayarlanmasını sağlayan kodlar.
		JButton btnCkarma = new JButton("Ç\u0131kar");
		btnCkarma.setBounds(111, 157, 89, 23);
		btnCkarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int sayi1=(int) Double.parseDouble(txtsayi1.getText());
				int sayi2=(int) Double.parseDouble(txtsayi2.getText());
				int sonuc= sayi1-sayi2;
				rakam = sonuc;
				int yuzbinlerBasamagi =  rakam%1000000/100000;
				int onbinlerBasamagi =  rakam%100000/10000;
				int binlerBasamagi = rakam%10000/1000;
				int yuzlerBasamagi = rakam%1000/100;
				int onlarBasamagi = rakam%100/10;
				int birlerBasamagi = rakam%10;
				String result = yuzler[yuzbinlerBasamagi]+onlar[onbinlerBasamagi]+birler[binlerBasamagi];{
					if(rakam>999) result = result + "bin";
					result = result + yuzler[yuzlerBasamagi]+onlar[onlarBasamagi]+birler[birlerBasamagi];{
					}
				}
				txtSonuc.setText(String.valueOf(result)); 

			}
		});
		frame.getContentPane().add(btnCkarma);


		//Çarpma işlemi butonunun tasarımı ve işlevselliğinin ayarlanmasını sağlayan kodlar.
		JButton btnCarpma = new JButton("Çarp");
		btnCarpma.setBounds(212, 157, 89, 23);
		btnCarpma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int sayi1=(int) Double.parseDouble(txtsayi1.getText());
				int sayi2=(int) Double.parseDouble(txtsayi2.getText());
				int sonuc= sayi1*sayi2;
				rakam = sonuc;
				int yuzbinlerBasamagi =  rakam%1000000/100000;
				int onbinlerBasamagi =  rakam%100000/10000;
				int binlerBasamagi = rakam%10000/1000;
				int yuzlerBasamagi = rakam%1000/100;
				int onlarBasamagi = rakam%100/10;
				int birlerBasamagi = rakam%10;
				String result = yuzler[yuzbinlerBasamagi]+onlar[onbinlerBasamagi]+birler[binlerBasamagi];{
					if(rakam>999) result = result + "bin";
					result = result + yuzler[yuzlerBasamagi]+onlar[onlarBasamagi]+birler[birlerBasamagi];{
					}
				}
				txtSonuc.setText(String.valueOf(result)); 

			}
		});
		frame.getContentPane().add(btnCarpma);


		//Bölme işlemi butonunun tasarımı ve işlevselliğinin ayarlanmasını sağlayan kodlar.
		JButton btnBolme = new JButton("Böl");
		btnBolme.setBounds(313, 157, 89, 23);
		btnBolme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int sayi1=(int) Double.parseDouble(txtsayi1.getText());
				int sayi2=(int) Double.parseDouble(txtsayi2.getText());
				int sonuc= sayi1/sayi2;
				rakam = sonuc;
				int yuzbinlerBasamagi =  rakam%1000000/100000;
				int onbinlerBasamagi =  rakam%100000/10000;
				int binlerBasamagi = rakam%10000/1000;
				int yuzlerBasamagi = rakam%1000/100;
				int onlarBasamagi = rakam%100/10;
				int birlerBasamagi = rakam%10;
				String result = yuzler[yuzbinlerBasamagi]+onlar[onbinlerBasamagi]+birler[binlerBasamagi];{
					if(rakam>999) result = result + "bin";
					result = result + yuzler[yuzlerBasamagi]+onlar[onlarBasamagi]+birler[birlerBasamagi];{
					}
				}
				txtSonuc.setText(String.valueOf(result)); 

			}
		});
		frame.getContentPane().add(btnBolme);

		JLabel lblSonuc = new JLabel("Sonuç :");
		lblSonuc.setBounds(10, 99, 132, 23);
		lblSonuc.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(lblSonuc);

		txtSonuc = new JTextField();
		txtSonuc.setBackground(Color.LIGHT_GRAY);
		txtSonuc.setBounds(179, 101, 215, 23);
		frame.getContentPane().add(txtSonuc);
		txtSonuc.setColumns(10);

		JButton btnNewButton = new JButton("Language");
		btnNewButton.setBounds(340, 237, 104, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSayiyiGiriniz.setText("1. number :");
				lblNewLabel.setText("2. number :");
				lblSonuc.setText("Result :");
				btnBolme.setText("Divide");
				btnCarpma.setText("Multiply");
				btnCkarma.setText("Substract");
				btnToplama.setText("Adittion");
			}
		});
		frame.getContentPane().add(btnNewButton);


		JComboBox comboBox = new JComboBox() {
			public void actionPerformed(ActionEvent e) {
				lblSayiyiGiriniz.setText("1. number :");
				lblNewLabel.setText("2. number :");
				lblSonuc.setText("Result :");
				btnBolme.setText("Divide");
				btnCarpma.setText("Multiply");
				btnCkarma.setText("Substract");
				btnToplama.setText("Adittion");
			}
		};
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Türkçe", "English"}));
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(212, 238, 116, 27);
		frame.getContentPane().add(comboBox);
	}
}