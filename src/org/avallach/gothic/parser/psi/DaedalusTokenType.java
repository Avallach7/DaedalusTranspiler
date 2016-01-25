package org.avallach.gothic.parser.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.avallach.gothic.parser.DaedalusLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DaedalusTokenType extends IElementType
{
	public DaedalusTokenType(@NotNull String debugName)
	{
		super(debugName, DaedalusLanguage.INSTANCE);
	}
}
