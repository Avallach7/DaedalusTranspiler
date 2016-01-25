package org.avallach.gothic.parser.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.avallach.gothic.parser.psi.DaedalusCompositeElement;
import org.jetbrains.annotations.NotNull;

public class DaedalusCompositeElementImpl extends ASTWrapperPsiElement implements DaedalusCompositeElement
{
	public DaedalusCompositeElementImpl(@NotNull ASTNode astNode)
	{
		super(astNode);
	}
}
