package org.avallach.gothic.parser;

import com.intellij.lang.Language;

public class DaedalusLanguage extends Language
{
	public static final DaedalusLanguage INSTANCE = new DaedalusLanguage();

	public DaedalusLanguage()
	{
		super("DAEDALUS");
	}
}
