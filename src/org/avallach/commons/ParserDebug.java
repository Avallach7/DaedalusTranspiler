package org.avallach.commons;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;

public class ParserDebug
{
	public static void psiToBuffer(PsiElement root, int indent, StringBuffer myBuffer)
	{
		if ((root != null && root.getText() != null && root.getText().trim().isEmpty()))
			return;
		StringUtil.repeatSymbol(myBuffer, ' ', indent);
		if (root == null)
		{
			myBuffer.append("<NULL>");
			return;
		}

		final String rootStr = root.toString();
		myBuffer.append(rootStr);
		StringUtil.repeatSymbol(myBuffer, ' ', Math.max(50 - rootStr.length() - indent, 1));
		myBuffer.append("| ");
		StringUtil.repeatSymbol(myBuffer, ' ', indent);
		PsiElement child = root.getFirstChild();
		if (child == null)
		{
			String text = root.getText();
			if (text == null)
				text = "<NULL-TEXT>";
			text = StringUtil.replace(text, "\n", "\\n");
			text = StringUtil.replace(text, "\r", "\\r");
			text = StringUtil.replace(text, "\t", "\\t");
			myBuffer.append(text);
		}
		myBuffer.append("\n");
		while (child != null)
		{
			psiToBuffer(child, indent + 2, myBuffer);
			child = child.getNextSibling();
		}
	}

	public static String psiToString(PsiElement root)
	{
		StringBuffer buffer = new StringBuffer();
		psiToBuffer(root, 0, buffer);
		return buffer.toString();
	}

	public static void logPsi(PsiElement root)
	{
		Debug.log("\n" + psiToString(root));
	}
}
