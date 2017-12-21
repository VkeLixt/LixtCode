package com.entor.recruit.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaUtils {
	
	/**
	 * ��֤�븴�ӳ���ȼ�
	 */
	
	public enum ComplexLevel{
		SIMPLE,MEDIUM,HARD
	}
	
	private static final char[] SIMPLE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private static final char[] MEDIUM = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Z', 'Y', 'Z' };
	private static final char[] HARD = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'Z', 'Y', 'Z' };

	private static Random random = new Random();

	/**
	 * ��֤��������<br>
	 * �򵥵���֤����4λ�������<br>
	 * �еȸ��ӵ���֤����5λ����ĸ��������Сд����������ɣ��и��ŵ�<br>
	 * ��ӵ���֤����6λ��ĸ��������Сд����������ɣ��и��ŵ�͸�����<br>
	 * ���Զ�����ŵ�͸����ߵ�����
	 * 
	 * @param width
	 *            ��֤��ͼƬ���
	 * @param height
	 *            ��֤��ͼƬ�߶�
	 * @param fontSize
	 *            �����С
	 * @param lineCount
	 *            ���������� ���Ը�����֤��ģʽ��Ч
	 * @param pointCount
	 *            ���ŵ� �Ը�����֤����еȸ��Ӷ���֤����Ч
	 * @param colours
	 *            �Ƿ��ɫ����
	 * @param border
	 *            �Ƿ���Ʊ߿�
	 * @param complexLevel
	 *            ���Ӷ�ö�����ͣ��紫��ComplexLevel.SIMPLE
	 * @return Object ����<br>
	 *         Object[0]��BufferImageͼ����Ϣ������ͨ��ImageIO.write((BufferImage)Object[0
	 *         ],"JPEG",HttpResponse.getOutputStream())д���ͻ���<br>
	 *         Object[1]�ڶ�λ����֤���ַ���
	 */
	public static Object[] getCaptchaImage(int width, int height, int fontSize, int lineCount, int pointCount,
			boolean border, boolean colours, ComplexLevel complexLevel) {
		System.err.println("��֤��������\n\n\n\n\\n\n\n\n\n\n\n");
		Object[] object = new Object[2];
		// ��֤���ַ���
		StringBuffer sb = new StringBuffer();
		// ���ַ�������ȥ�ַ������λ��
		int position = 0;

		// ͼ������
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// ��ȡһ��ͼ��
		Graphics grap = bi.getGraphics();
		// ����һ������
		grap.fillRect(0, 0, width, height);
		// ��������
		grap.setFont(new Font("Arial", Font.BOLD, fontSize));
		// ����������ɫ
		grap.setColor(Color.BLACK);
		// ����һ���߿�
		if (border)
			grap.drawRect(0, 0, width - 1, height - 1);
		switch (complexLevel) {
		case SIMPLE:
			for (int i = 0; i < 4; i++) {
				// ���������ɫ
				if (colours)
					grap.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
				position = random.nextInt(SIMPLE.length);
				// д�ַ���ͼƬ���ʵ�λ��
				grap.drawString(SIMPLE[position] + "",
						(i * ((width - 10) / 4)) + 5 + random.nextInt(((width - 10) / 4) / 2),
						height / 2 + random.nextInt(height / 2));
				sb.append(SIMPLE[position]);
			}
			break;
		case MEDIUM:
			// ���Ƹ��ŵ�
			for (int k = 0; k < pointCount; k++) {
				grap.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
			}
			for (int i = 0; i < 5; i++) {
				// ���������ɫ
				if (colours)
					grap.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
				position = random.nextInt(MEDIUM.length);
				// д�ַ���ͼƬ���ʵ�λ��
				grap.drawString(MEDIUM[position] + "",
						(i * ((width - 10) / 5)) + 5 + random.nextInt(((width - 10) / 5) / 2),
						height / 2 + random.nextInt(height / 2));
				sb.append(MEDIUM[position]);
			}
			break;
		case HARD:
			// ���Ƹ�����
			for (int j = 0; j < lineCount; j++) {
				grap.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width),
						random.nextInt(height));
			}
			// ���Ƹ��ŵ�
			for (int k = 0; k < pointCount; k++) {
				grap.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
			}
			for (int i = 0; i < 6; i++) {
				// ���������ɫ
				if (colours)
					grap.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
				position = random.nextInt(HARD.length);
				// д�ַ���ͼƬ���ʵ�λ��
				grap.drawString(HARD[position] + "",
						(i * ((width - 10) / 6)) + 5 + random.nextInt(((width - 10) / 6) / 2),
						height / 2 + random.nextInt(height / 2));
				sb.append(HARD[position]);
			}
			break;
		default:
			break;
		}
		// �ͷ�Graphics����
		grap.dispose();

		object[0] = bi;
		object[1] = sb.toString();

		return object;
	}
}
