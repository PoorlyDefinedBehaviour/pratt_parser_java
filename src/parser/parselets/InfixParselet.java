package parser.parselets;

import lexer.Token;
import parser.Parser;
import parser.expressions.Expression;

public interface InfixParselet {
  public Expression parse(Parser parser, Expression left, Token token);

  public int getPrecedence();
}
