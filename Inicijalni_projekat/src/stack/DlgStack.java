package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCircleX;
	private JTextField txtCircleY;
	private JTextField txtRadius;
	private int var=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setResizable(false);
		getContentPane().setBackground(new Color(224, 255, 255));
		setModal(true);
		setBounds(100, 100, 350, 220);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 434, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 208, 33, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.anchor = GridBagConstraints.NORTH;
		gbc_contentPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		{
			JPanel pnlCenter = new JPanel();
			pnlCenter.setBackground(new Color(224, 255, 255));
			GridBagConstraints gbc_pnlCenter = new GridBagConstraints();
			gbc_pnlCenter.insets = new Insets(0, 0, 5, 0);
			gbc_pnlCenter.fill = GridBagConstraints.BOTH;
			gbc_pnlCenter.gridx = 0;
			gbc_pnlCenter.gridy = 1;
			getContentPane().add(pnlCenter, gbc_pnlCenter);
			GridBagLayout gbl_pnlCenter = new GridBagLayout();
			gbl_pnlCenter.columnWidths = new int[] { 0, 0, 0, 0, 0 };
			gbl_pnlCenter.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_pnlCenter.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
			gbl_pnlCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnlCenter.setLayout(gbl_pnlCenter);
			{
				JLabel lblCenterCoordinate = new JLabel("Center coordinate");
				GridBagConstraints gbc_lblCenterCoordinate = new GridBagConstraints();
				gbc_lblCenterCoordinate.anchor = GridBagConstraints.EAST;
				gbc_lblCenterCoordinate.insets = new Insets(0, 0, 5, 5);
				gbc_lblCenterCoordinate.gridx = 1;
				gbc_lblCenterCoordinate.gridy = 0;
				pnlCenter.add(lblCenterCoordinate, gbc_lblCenterCoordinate);
			}
			{
				JLabel lblCircleX = new JLabel("  X coordinate");
				GridBagConstraints gbc_lblCircleX = new GridBagConstraints();
				gbc_lblCircleX.anchor = GridBagConstraints.EAST;
				gbc_lblCircleX.insets = new Insets(0, 0, 5, 5);
				gbc_lblCircleX.gridx = 2;
				gbc_lblCircleX.gridy = 1;
				pnlCenter.add(lblCircleX, gbc_lblCircleX);
			}
			{
				txtCircleX = new JTextField();
				GridBagConstraints gbc_txtCircleX = new GridBagConstraints();
				gbc_txtCircleX.insets = new Insets(0, 0, 5, 0);
				gbc_txtCircleX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCircleX.gridx = 3;
				gbc_txtCircleX.gridy = 1;
				pnlCenter.add(txtCircleX, gbc_txtCircleX);
				txtCircleX.setColumns(10);
			}
			{
				JLabel lblCircleY = new JLabel("  Y coordinate");
				GridBagConstraints gbc_lblCircleY = new GridBagConstraints();
				gbc_lblCircleY.anchor = GridBagConstraints.EAST;
				gbc_lblCircleY.insets = new Insets(0, 0, 5, 5);
				gbc_lblCircleY.gridx = 2;
				gbc_lblCircleY.gridy = 2;
				pnlCenter.add(lblCircleY, gbc_lblCircleY);
			}
			{
				txtCircleY = new JTextField();
				GridBagConstraints gbc_txtCircleY = new GridBagConstraints();
				gbc_txtCircleY.insets = new Insets(0, 0, 5, 0);
				gbc_txtCircleY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCircleY.gridx = 3;
				gbc_txtCircleY.gridy = 2;
				pnlCenter.add(txtCircleY, gbc_txtCircleY);
				txtCircleY.setColumns(10);
			}
			{
				JLabel lblProperties = new JLabel("Properties");
				GridBagConstraints gbc_lblProperties = new GridBagConstraints();
				gbc_lblProperties.insets = new Insets(0, 0, 5, 5);
				gbc_lblProperties.gridx = 1;
				gbc_lblProperties.gridy = 4;
				pnlCenter.add(lblProperties, gbc_lblProperties);
			}
			{
				JLabel lblCircleRadius = new JLabel("  Radius");
				GridBagConstraints gbc_lblCircleRadius = new GridBagConstraints();
				gbc_lblCircleRadius.anchor = GridBagConstraints.WEST;
				gbc_lblCircleRadius.insets = new Insets(0, 0, 0, 5);
				gbc_lblCircleRadius.gridx = 2;
				gbc_lblCircleRadius.gridy = 5;
				pnlCenter.add(lblCircleRadius, gbc_lblCircleRadius);
			}
			{
				txtRadius = new JTextField();
				GridBagConstraints gbc_txtRadius = new GridBagConstraints();
				gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRadius.gridx = 3;
				gbc_txtRadius.gridy = 5;
				pnlCenter.add(txtRadius, gbc_txtRadius);
				txtRadius.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(224, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 2;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							if (txtCircleX.getText().isEmpty() || txtCircleY.getText().isEmpty()
									|| txtRadius.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "You need to fill all of these fields!");
							} else if (Integer.parseInt(txtRadius.getText()) <= 0) {
								JOptionPane.showMessageDialog(null, "Radius must be greater than 0!");
							} else {
								setVisible(false);
								var=1;
							}

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "You have to enter numbers!");
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtCircleX() {
		return txtCircleX;
	}

	public void setTxtCircleX(JTextField txtCircleX) {
		this.txtCircleX = txtCircleX;
	}

	public JTextField getTxtCircleY() {
		return txtCircleY;
	}

	public void setTxtCircleY(JTextField txtCircleY) {
		this.txtCircleY = txtCircleY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public int getVar() {
		return var;
	}

	public void setVar(int var) {
		this.var = var;
	}

	
	

	
	
}
