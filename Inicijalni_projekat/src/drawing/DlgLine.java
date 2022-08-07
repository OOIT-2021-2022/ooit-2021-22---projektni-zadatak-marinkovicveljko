package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXStart;
	private JTextField txtYStart;
	private JTextField txtXEnd;
	private JTextField txtYEnd;
	public boolean okay;
	private Color color;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setTitle("Line");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPoint = new JLabel("Start Point");
			GridBagConstraints gbc_lblStartPoint = new GridBagConstraints();
			gbc_lblStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPoint.gridx = 1;
			gbc_lblStartPoint.gridy = 0;
			contentPanel.add(lblStartPoint, gbc_lblStartPoint);
		}
		{
			JLabel lblXStart = new JLabel("X coordinate");
			GridBagConstraints gbc_lblXStart = new GridBagConstraints();
			gbc_lblXStart.insets = new Insets(0, 0, 5, 5);
			gbc_lblXStart.anchor = GridBagConstraints.EAST;
			gbc_lblXStart.gridx = 2;
			gbc_lblXStart.gridy = 1;
			contentPanel.add(lblXStart, gbc_lblXStart);
		}
		{
			txtXStart = new JTextField();
			GridBagConstraints gbc_txtXStart = new GridBagConstraints();
			gbc_txtXStart.insets = new Insets(0, 0, 5, 0);
			gbc_txtXStart.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXStart.gridx = 3;
			gbc_txtXStart.gridy = 1;
			contentPanel.add(txtXStart, gbc_txtXStart);
			txtXStart.setColumns(10);
		}
		{
			JLabel lblYStart = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblYStart = new GridBagConstraints();
			gbc_lblYStart.anchor = GridBagConstraints.EAST;
			gbc_lblYStart.insets = new Insets(0, 0, 5, 5);
			gbc_lblYStart.gridx = 2;
			gbc_lblYStart.gridy = 2;
			contentPanel.add(lblYStart, gbc_lblYStart);
		}
		{
			txtYStart = new JTextField();
			GridBagConstraints gbc_txtYStart = new GridBagConstraints();
			gbc_txtYStart.insets = new Insets(0, 0, 5, 0);
			gbc_txtYStart.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYStart.gridx = 3;
			gbc_txtYStart.gridy = 2;
			contentPanel.add(txtYStart, gbc_txtYStart);
			txtYStart.setColumns(10);
		}
		{
			JLabel lblEndPoint = new JLabel("End Point");
			GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
			gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPoint.gridx = 1;
			gbc_lblEndPoint.gridy = 4;
			contentPanel.add(lblEndPoint, gbc_lblEndPoint);
		}
		{
			JLabel lblXEnd = new JLabel("X coordinate");
			GridBagConstraints gbc_lblXEnd = new GridBagConstraints();
			gbc_lblXEnd.anchor = GridBagConstraints.EAST;
			gbc_lblXEnd.insets = new Insets(0, 0, 5, 5);
			gbc_lblXEnd.gridx = 2;
			gbc_lblXEnd.gridy = 5;
			contentPanel.add(lblXEnd, gbc_lblXEnd);
		}
		{
			txtXEnd = new JTextField();
			GridBagConstraints gbc_txtXEnd = new GridBagConstraints();
			gbc_txtXEnd.insets = new Insets(0, 0, 5, 0);
			gbc_txtXEnd.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXEnd.gridx = 3;
			gbc_txtXEnd.gridy = 5;
			contentPanel.add(txtXEnd, gbc_txtXEnd);
			txtXEnd.setColumns(10);
		}
		{
			JLabel lblYEnd = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblYEnd = new GridBagConstraints();
			gbc_lblYEnd.anchor = GridBagConstraints.EAST;
			gbc_lblYEnd.insets = new Insets(0, 0, 5, 5);
			gbc_lblYEnd.gridx = 2;
			gbc_lblYEnd.gridy = 6;
			contentPanel.add(lblYEnd, gbc_lblYEnd);
		}
		{
			txtYEnd = new JTextField();
			GridBagConstraints gbc_txtYEnd = new GridBagConstraints();
			gbc_txtYEnd.insets = new Insets(0, 0, 5, 0);
			gbc_txtYEnd.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYEnd.gridx = 3;
			gbc_txtYEnd.gridy = 6;
			contentPanel.add(txtYEnd, gbc_txtYEnd);
			txtYEnd.setColumns(10);
		}
		{
			JButton btnBorderColor = new JButton("Border color");
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Please choose color", color);
					btnBorderColor.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnBorderColor.gridx = 1;
			gbc_btnBorderColor.gridy = 7;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						okay = true;
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
						okay=false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JTextField getTxtXStart() {
		return txtXStart;
	}

	public void setTxtXStart(JTextField txtXStart) {
		this.txtXStart = txtXStart;
	}

	public JTextField getTxtYStart() {
		return txtYStart;
	}

	public void setTxtYStart(JTextField txtYStart) {
		this.txtYStart = txtYStart;
	}

	public JTextField getTxtXEnd() {
		return txtXEnd;
	}

	public void setTxtXEnd(JTextField txtXEnd) {
		this.txtXEnd = txtXEnd;
	}

	public JTextField getTxtYEnd() {
		return txtYEnd;
	}

	public void setTxtYEnd(JTextField txtYEnd) {
		this.txtYEnd = txtYEnd;
	}

	public boolean isOkay() {
		return okay;
	}

	public void setOkay(boolean okay) {
		this.okay = okay;
	}
	
	
	

}
