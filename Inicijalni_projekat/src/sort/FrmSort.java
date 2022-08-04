package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setTitle("Veljko Marinkovic IT15-2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.CYAN);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		GridBagLayout gbl_pnlNorth = new GridBagLayout();
		gbl_pnlNorth.columnWidths = new int[]{187, 49, 0};
		gbl_pnlNorth.rowHeights = new int[]{14, 0};
		gbl_pnlNorth.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlNorth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlNorth.setLayout(gbl_pnlNorth);
		
		JLabel lblSortCircle = new JLabel("Sort Circle");
		lblSortCircle.setForeground(Color.MAGENTA);
		GridBagConstraints gbc_lblSortCircle = new GridBagConstraints();
		gbc_lblSortCircle.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSortCircle.gridx = 1;
		gbc_lblSortCircle.gridy = 0;
		pnlNorth.add(lblSortCircle, gbc_lblSortCircle);
		
		JPanel pnlCentre = new JPanel();
		contentPane.add(pnlCentre, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentre = new GridBagLayout();
		gbl_pnlCentre.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlCentre.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlCentre.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentre.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlCentre.setLayout(gbl_pnlCentre);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 4;
		pnlCentre.add(scrollPane, gbc_scrollPane);
		
		JList lstSort = new JList();
		scrollPane.setViewportView(lstSort);
		lstSort.setModel(dlm);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);
		
		JButton btnAddCircle = new JButton("Add Circle");
		btnAddCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort openSortDialog = new DlgSort();
				openSortDialog.setVisible(true);
				try {
					int x = Integer.parseInt(openSortDialog.getTxtCircleX().getText());
					int y = Integer.parseInt(openSortDialog.getTxtCircleY().getText());
					int radius = Integer.parseInt(openSortDialog.getTxtRadius().getText());
					
					Circle c = new Circle(new Point(x,y), radius);
					dlm.add(0, c);
					
				} 
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "You couldn't use letters in fields");		
				}
				
				
			}
		});
		GridBagConstraints gbc_btnAddCircle = new GridBagConstraints();
		gbc_btnAddCircle.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddCircle.gridx = 2;
		gbc_btnAddCircle.gridy = 0;
		pnlSouth.add(btnAddCircle, gbc_btnAddCircle);
		
		JButton btnSortCircles = new JButton("Sort Circles");
		btnSortCircles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSortCircles = new GridBagConstraints();
		gbc_btnSortCircles.gridwidth = 3;
		gbc_btnSortCircles.gridx = 10;
		gbc_btnSortCircles.gridy = 0;
		pnlSouth.add(btnSortCircles, gbc_btnSortCircles);
	}

}
