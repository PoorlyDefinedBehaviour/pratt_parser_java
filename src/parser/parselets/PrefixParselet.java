package parser.parselets;

import lexer.Token;
import parser.Parser;
import parser.expressions.*;

public interface PrefixParselet {
  public Expression parse(Parser parser, Token token);
}
