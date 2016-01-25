package org.avallach.gothic.parser.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import org.avallach.gothic.parser.DaedalusFileType;
import org.avallach.gothic.parser.DaedalusLanguage;
import org.jetbrains.annotations.NotNull;

public class DaedalusFile extends PsiFileBase
{
	public DaedalusFile(FileViewProvider viewProvider)
	{
		super(viewProvider, DaedalusLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public FileType getFileType()
	{
		return DaedalusFileType.INSTANCE;
	}
}
