package org.avallach.gothic;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import org.avallach.commons.Debug;
import org.avallach.commons.PsiLineNumberUtil;
import org.avallach.gothic.parser.DaedalusParserDefinition;
import org.intellij.grammar.LightPsi;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParsingTest
{
    public static void main(String[] args) throws IOException
	{
		String sourcesPath = args[0];
		Files.find
		(
			Paths.get(sourcesPath),
			Integer.MAX_VALUE,
			(path, basicFileAttributes) -> path.toString().endsWith(".d") || path.toString().endsWith(".D"),
			FileVisitOption.FOLLOW_LINKS
		).forEach(sourcePath ->
		{
			try
			{
				String name = sourcePath.getFileName().toString();
				String text = FileUtil.loadFile(sourcePath.toFile(), "Cp1252");
				PsiFile psi = LightPsi.parseFile(name, text, DaedalusParserDefinition.INSTANCE);
				for(PsiErrorElement error : PsiTreeUtil.findChildrenOfType(psi, PsiErrorElement.class))
					Debug.log(sourcePath + ":" +
							PsiLineNumberUtil.getLineNumber(error) + ": " +
							error.getErrorDescription());
			}
			catch (IOException e)
			{
				Debug.log(sourcePath + ":" + e.getMessage());
			}
		});
    }
}
