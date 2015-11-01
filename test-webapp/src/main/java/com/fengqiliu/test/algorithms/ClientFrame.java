package com.fengqiliu.test.algorithms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientFrame extends JFrame {
    private static final long serialVersionUID = -5772442258299648644L;

    private static SortContext context;    // 上下文

    private JPanel contentPane;
    private JTextField unsortedSequenceField;
    private JTextField sortedSequenceField;
    private JComboBox<String> comboBox;
    private JTextPane messagePane;

    /**
     * Create the frame.
     */
    public ClientFrame() {
        setTitle("排序算法演示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("待排序数列：");
        label.setBounds(37, 40, 79, 15);
        contentPane.add(label);

        unsortedSequenceField = new JTextField();
        unsortedSequenceField.setBounds(130, 37, 271, 21);
        unsortedSequenceField.setToolTipText("请输入整数序列，数字之间用逗号隔开！");
        contentPane.add(unsortedSequenceField);
        unsortedSequenceField.setColumns(10);

        JLabel label_1 = new JLabel("排序后数列：");
        label_1.setBounds(37, 78, 79, 15);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("排序算法：");
        label_2.setBounds(37, 115, 79, 15);
        contentPane.add(label_2);

        comboBox = new JComboBox<String>();
        initComboBox();
        comboBox.setBounds(129, 112, 225, 21);
        contentPane.add(comboBox);

        sortedSequenceField = new JTextField();
        sortedSequenceField.setBounds(129, 75, 272, 21);
        contentPane.add(sortedSequenceField);
        sortedSequenceField.setColumns(10);

        messagePane = new JTextPane();

        JScrollPane scrollPane = new JScrollPane(messagePane);
        scrollPane.setBounds(37, 156, 364, 264);
        contentPane.add(scrollPane);

        JButton button = new JButton("排序");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sorterName = comboBox.getSelectedItem().toString();
                try {
                    initContext(sorterName);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                messagePane.setText("");
                context.getSortResult();
                sortedSequenceField.setText(Util.intArrayToString(context
                        .getSortedSequence()));
            }
        });
        button.setBounds(308, 429, 93, 23);
        contentPane.add(button);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientFrame frame = new ClientFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //	初始化 combobox 中的 子项
    private void initComboBox() {
        for (String item : SortContext.SORTER_NAMES) {
            comboBox.addItem(item);
        }

    }

    //	根据选择的 排序算法初始化 上下文
    private SortContext initContext(String sorterName) throws Exception {
        int[] unsortedSequence = null;
        try {
            unsortedSequence = Util.stringToIntArray(unsortedSequenceField
                    .getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "您输入的整数序列不正确，请重新输入！每个数字之间请用逗号隔开！");
        }

        switch (sorterName) {
            case BubbleSort.NAME:
                return context = new SortContext(new BubbleSort(),
                        unsortedSequence, messagePane);

            case QuickSort.NAME:
                return context = new SortContext(new QuickSort(),
                        unsortedSequence, messagePane);

            case ShellSort.NAME:
                return context = new SortContext(new ShellSort(),
                        unsortedSequence, messagePane);

            case StraightInsertSort.NAME:
                return context = new SortContext(new StraightInsertSort(),
                        unsortedSequence, messagePane);

            case BinaryInsertionSort.NAME:
                return context = new SortContext(new BinaryInsertionSort(),
                        unsortedSequence, messagePane);

            case BaseSort.NAME:
                return context = new SortContext(new BaseSort(),
                        unsortedSequence, messagePane);

            case SelectSort.NAME:
                return context = new SortContext(new SelectSort(),
                        unsortedSequence, messagePane);

            case HeapSort.NAME:
                return context = new SortContext(new HeapSort(),
                        unsortedSequence, messagePane);

            case MergeSort.NAME:
                return context = new SortContext(new MergeSort(),
                        unsortedSequence, messagePane);
            default:
                throw new IllegalArgumentException(
                        "this is an unKnown selected combobox item! please select another one!");
        }

    }

}
