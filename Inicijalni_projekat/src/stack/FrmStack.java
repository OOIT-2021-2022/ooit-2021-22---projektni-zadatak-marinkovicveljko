package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		setForeground(Color.WHITE);
		setTitle("Veljko Marinkovic IT15-2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 7;
		gbc_scrollPane.gridy = 7;
		pnlCenter.add(scrollPane, gbc_scrollPane);
		
		JList lstCircle = new JList();
		scrollPane.setViewportView(lstCircle);
		lstCircle.setModel(dlm); // Sve sto se dodaje u model, dodaje se i u listu
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.CYAN);
		pnlNorth.setForeground(Color.BLACK);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblCircleStack = new JLabel("Circle Stack");
		lblCircleStack.setForeground(Color.RED);
		pnlNorth.add(lblCircleStack);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAddCirlcle = new JButton("Add Circle");
		btnAddCirlcle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dialogStack = new DlgStack();
				dialogStack.setVisible(true);
				
				try {
				 int x = Integer.parseInt(dialogStack.getTxtCircleX().getText());
				 int y = Integer.parseInt(dialogStack.getTxtCircleY().getText());
				 int radius = Integer.parseInt(dialogStack.getTxtRadius().getText());
				 
				 Circle c = new Circle(new Point(x,y), radius);
				 dlm.add(0, c);
				} catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Cannot add letters in list!");
				}
				
			}
		});
		pnlSouth.add(btnAddCirlcle);
		
		JButton btnDeleteCircle = new JButton("Delete Circle");
		btnDeleteCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dlm.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "List is empty!");
					}
					else
					{
						dlm.remove(0);
					}
				} catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, "List must contains at least 1 element");
				}
				
			}
		});
		pnlSouth.add(btnDeleteCircle);
	}
	
	

}
