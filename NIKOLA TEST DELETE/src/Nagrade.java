import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Nagrade extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nagrade frame = new Nagrade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Nagrade() throws IOException {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setBounds(10, 41, 52, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime:");
		lblNewLabel_1.setBounds(10, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(66, 38, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 63, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPodaci = new JLabel("Podaci");
		lblPodaci.setBounds(132, 13, 46, 14);
		contentPane.add(lblPodaci);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u017Deli nagradu");
		chckbxNewCheckBox.setBounds(6, 90, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Stigao mail");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				//Unos novog korisnickog e-maila
				
				Servis s = new Servis();
				try (FileWriter writer = new FileWriter(new File("Inbox.txt"), true)) {
		            writer.write(s.InsertMail(textField.getText(), textField_1.getText(), chckbxNewCheckBox.isSelected())+System.lineSeparator());
			
				
				} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		
		btnNewButton.setBounds(76, 119, 149, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Podeli nagradu");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Dodeljivanje nagrada (pronadje i ispise korisnika sa true, broj nagrada--, loguje dobitnike)
				
				try (BufferedReader br = new BufferedReader(new FileReader("Inbox.txt"))) {
				    String line;
				    
				    while ((line = br.readLine()) != null) {
				    	
				    	String bool = line.substring(line.lastIndexOf(" ")+1);
				    	System.out.println(line);
				    	if (bool.equals("true"))
				    	{
				    		textField_2.setText(line);
				    		break;
			    		}
				    	else
				    	{
				    		continue;
				    	}
				    }
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(76, 153, 149, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Poslednji dobitnik:");
		lblNewLabel_2.setBounds(10, 187, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(10, 212, 278, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOstaloJo = new JLabel("Ostalo jo\u0161:");
		lblOstaloJo.setBounds(10, 243, 71, 14);
		contentPane.add(lblOstaloJo);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(76, 243, 40, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
