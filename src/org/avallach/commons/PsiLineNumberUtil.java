package org.avallach.commons;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.ArrayUtil;
import com.intellij.util.containers.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PsiLineNumberUtil
{
	private static Map<String, int[]> lineEndingsByFile = new HashMap<>();
	private static int[] getLineEndings(PsiFile file)
	{
		String path = file.getVirtualFile().getPath();
		int[] lineEndings = lineEndingsByFile.get(path);
		if (lineEndings == null)
		{
			List<Integer> lineEndingsList = new ArrayList<>();
			String allText = file.getText();
			int fileLength = allText.length();
			for(int offset = 0; offset < fileLength; offset++)
				if (allText.charAt(offset) == '\n')
					lineEndingsList.add(offset+1);
			lineEndings = ArrayUtil.toIntArray(lineEndingsList);
			lineEndingsByFile.put(path, lineEndings);
		}
		return lineEndings;
	}
	public static int getLineNumber(PsiElement element)
	{
		int offset = element.getTextOffset();
		int[] lineEndings = getLineEndings(element.getContainingFile());
		if (lineEndings.length == 0)
			return 1;
		for(int lineNumber = 0; lineNumber < lineEndings.length; lineNumber++)
			if (offset < lineEndings[lineNumber])
				return lineNumber+1;
		return lineEndings.length+2;
	}
}
