package parser.parselets;

import lexer.Token;
import parser.*;
import parser.expressions.Expression;
import parser.expressions.IdentifierExpression;

public class IdentifierParselet implements PrefixParselet {
  @Override
  public Expression parse(Parser parser, Token token) {
    return new IdentifierExpression(token.lexeme);
  }
}
