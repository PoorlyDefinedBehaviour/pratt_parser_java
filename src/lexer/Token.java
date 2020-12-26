package lexer;

public class Token {
  public final String lexeme;
  public final TokenType type;

  public Token(TokenType type, String lexeme) {
    this.type = type;
    this.lexeme = lexeme;
  }
}
