package 软引用;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

import javax.swing.ImageIcon;


/**
 * 引用图片资源的类
 * @author Administrator
 *
 */
public class ReferenceBitmap extends ReferenceObject<ImageIcon>{
	String url;
	public ReferenceBitmap(String url) {
		this.url = url;
	}

	@Override
	protected Reference<ImageIcon> getReference(ImageIcon imageIcon) {
		return new SoftReference<ImageIcon>(imageIcon);
	}

	@Override
	protected ImageIcon getInstance() {
		return new ImageIcon(url);
	}
	
}
