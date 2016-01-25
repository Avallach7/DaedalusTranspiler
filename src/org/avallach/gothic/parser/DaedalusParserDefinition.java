package org.avallach.gothic.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.avallach.gothic.parser.psi.DaedalusFile;
import org.avallach.gothic.parser.psi.DaedalusTypes;
import org.jetbrains.annotations.NotNull;

public class DaedalusParserDefinition implements ParserDefinition
{
	public static DaedalusParserDefinition INSTANCE = new DaedalusParserDefinition();
	private static final IFileElementType FILE_NODE_TYPE = new IFileElementType(DaedalusLanguage.INSTANCE);

	@NotNull
	@Override
	public Lexer createLexer(Project project)
	{
		return new FlexAdapter(new _DaedalusLexer(null));
	}

	@Override
	public PsiParser createParser(Project project)
	{
		return new DaedalusParser();
	}

	@Override
	public IFileElementType getFileNodeType()
	{
		return FILE_NODE_TYPE;
	}

	@NotNull
	@Override
	public TokenSet getWhitespaceTokens()
	{
		return TokenSet.create(TokenType.WHITE_SPACE);
	}

	@NotNull
	@Override
	public TokenSet getCommentTokens()
	{
		return TokenSet.create(DaedalusTypes.LINE_COMMENT, DaedalusTypes.BLOCK_COMMENT);
	}

	@NotNull
	@Override
	public TokenSet getStringLiteralElements()
	{
		return TokenSet.create(DaedalusTypes.STRING_LITERAL);
	}

	@NotNull
	@Override
	public PsiElement createElement(ASTNode node)
	{
		return DaedalusTypes.Factory.createElement(node);
	}

	@Override
	public PsiFile createFile(FileViewProvider viewProvider)
	{
		return new DaedalusFile(viewProvider);
	}

	@Override
	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		return SpaceRequirements.MAY;
	}
}
