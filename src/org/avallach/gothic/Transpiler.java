package org.avallach.gothic;

import com.intellij.psi.PsiFile;
import org.avallach.commons.Debug;
import org.avallach.commons.ParserDebug;
import org.avallach.gothic.parser.DaedalusParserDefinition;
import org.intellij.grammar.LightPsi;

import java.io.File;
import java.io.IOException;

public class Transpiler
{
    public static void main(String[] args) throws IOException
	{
		File sourceFile = new File("D:\\userdata\\Documents\\GitHub\\DaedalusTranspiler\\test\\resources\\org\\avallach\\gothic\\Transpiler\\test.d");
		PsiFile psi = LightPsi.parseFile(sourceFile, DaedalusParserDefinition.INSTANCE);
		ParserDebug.logPsi(psi);
    }
}
