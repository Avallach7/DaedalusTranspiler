package org.avallach.gothic.parser;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DaedalusFileType extends LanguageFileType
{
	public static final DaedalusFileType INSTANCE = new DaedalusFileType();

	private DaedalusFileType()
	{
		super(DaedalusLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName()
	{
		return getLanguage().getDisplayName();
	}

	@NotNull
	@Override
	public String getDescription()
	{
		return getName();
	}

	@NotNull
	@Override
	public String getDefaultExtension()
	{
		return "d";
	}

	@Nullable
	@Override
	public Icon getIcon()
	{
		return null;
	}
}
