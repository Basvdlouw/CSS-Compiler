// Generated from D:/school/ASD/APP/CSS-Compiler/src/main/antlr4/nl/han/ica/icss/parser\ICSS.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ICSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN_BRACE=1, CLOSE_BRACE=2, SEMICOLON=3, COLON=4, PLUS=5, MIN=6, MUL=7, 
		ASSIGNMENT_OPERATOR=8, PIXELSIZE=9, PERCENTAGE=10, SCALAR=11, COLOR=12, 
		ID_IDENT=13, CLASS_IDENT=14, LOWER_IDENT=15, CAPITAL_IDENT=16, WS=17;
	public static final int
		RULE_stylesheet = 0, RULE_variableAssignment = 1, RULE_stylerule = 2, 
		RULE_stylesheetPart = 3, RULE_declaration = 4, RULE_expression = 5, RULE_operation = 6, 
		RULE_property = 7, RULE_literal = 8, RULE_selector = 9, RULE_variableReference = 10;
	public static final String[] ruleNames = {
		"stylesheet", "variableAssignment", "stylerule", "stylesheetPart", "declaration", 
		"expression", "operation", "property", "literal", "selector", "variableReference"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "';'", "':'", "'+'", "'-'", "'*'", "':='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", "COLON", "PLUS", "MIN", 
		"MUL", "ASSIGNMENT_OPERATOR", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", 
		"ID_IDENT", "CLASS_IDENT", "LOWER_IDENT", "CAPITAL_IDENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ICSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public List<StylesheetPartContext> stylesheetPart() {
			return getRuleContexts(StylesheetPartContext.class);
		}
		public StylesheetPartContext stylesheetPart(int i) {
			return getRuleContext(StylesheetPartContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_IDENT) | (1L << CLASS_IDENT) | (1L << LOWER_IDENT) | (1L << CAPITAL_IDENT))) != 0)) {
				{
				{
				setState(22);
				stylesheetPart();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableAssignmentContext extends ParserRuleContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(ICSSParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			variableReference();
			setState(29);
			match(ASSIGNMENT_OPERATOR);
			setState(30);
			expression();
			setState(31);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StyleruleContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public List<StyleruleContext> stylerule() {
			return getRuleContexts(StyleruleContext.class);
		}
		public StyleruleContext stylerule(int i) {
			return getRuleContext(StyleruleContext.class,i);
		}
		public StyleruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylerule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylerule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylerule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStylerule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleruleContext stylerule() throws RecognitionException {
		StyleruleContext _localctx = new StyleruleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stylerule);
		int _la;
		try {
			int _alt;
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				selector();
				setState(34);
				match(OPEN_BRACE);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOWER_IDENT) {
					{
					{
					setState(35);
					declaration();
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(41);
					variableAssignment();
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(47);
				match(CLOSE_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				selector();
				setState(50);
				match(OPEN_BRACE);
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(51);
						declaration();
						}
						} 
					}
					setState(56);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(57);
					variableAssignment();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(63);
					stylerule();
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_IDENT) | (1L << CLASS_IDENT) | (1L << LOWER_IDENT))) != 0) );
				setState(68);
				match(CLOSE_BRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				selector();
				setState(71);
				match(OPEN_BRACE);
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(72);
						declaration();
						}
						} 
					}
					setState(77);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					stylerule();
					}
					}
					setState(81); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_IDENT) | (1L << CLASS_IDENT) | (1L << LOWER_IDENT))) != 0) );
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(83);
					variableAssignment();
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(89);
				match(CLOSE_BRACE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				selector();
				setState(92);
				match(OPEN_BRACE);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(93);
					variableAssignment();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOWER_IDENT) {
					{
					{
					setState(99);
					declaration();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(CLOSE_BRACE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				selector();
				setState(108);
				match(OPEN_BRACE);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(109);
					variableAssignment();
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(115);
						declaration();
						}
						} 
					}
					setState(120);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(121);
					stylerule();
					}
					}
					setState(124); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_IDENT) | (1L << CLASS_IDENT) | (1L << LOWER_IDENT))) != 0) );
				setState(126);
				match(CLOSE_BRACE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				selector();
				setState(129);
				match(OPEN_BRACE);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(130);
					variableAssignment();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(136);
						stylerule();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(139); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOWER_IDENT) {
					{
					{
					setState(141);
					declaration();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147);
				match(CLOSE_BRACE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(149);
				selector();
				setState(150);
				match(OPEN_BRACE);
				setState(152); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(151);
						stylerule();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(154); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOWER_IDENT) {
					{
					{
					setState(156);
					declaration();
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(162);
					variableAssignment();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(168);
				match(CLOSE_BRACE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(170);
				selector();
				setState(171);
				match(OPEN_BRACE);
				setState(173); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(172);
						stylerule();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(175); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAPITAL_IDENT) {
					{
					{
					setState(177);
					variableAssignment();
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOWER_IDENT) {
					{
					{
					setState(183);
					declaration();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				match(CLOSE_BRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StylesheetPartContext extends ParserRuleContext {
		public StyleruleContext stylerule() {
			return getRuleContext(StyleruleContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public StylesheetPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheetPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylesheetPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylesheetPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStylesheetPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetPartContext stylesheetPart() throws RecognitionException {
		StylesheetPartContext _localctx = new StylesheetPartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stylesheetPart);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_IDENT:
			case CLASS_IDENT:
			case LOWER_IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				stylerule();
				}
				break;
			case CAPITAL_IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				variableAssignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ICSSParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaration);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				property();
				setState(198);
				match(COLON);
				setState(199);
				expression();
				setState(200);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				property();
				setState(203);
				match(COLON);
				setState(204);
				variableReference();
				setState(205);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				variableReference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				operation(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
	 
		public OperationContext() { }
		public void copyFrom(OperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableInOperationContext extends OperationContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public VariableInOperationContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableInOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableInOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableInOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InversiveAdditionContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode MIN() { return getToken(ICSSParser.MIN, 0); }
		public InversiveAdditionContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterInversiveAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitInversiveAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitInversiveAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ICSSParser.MUL, 0); }
		public MultiplicationContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralInOperationContext extends OperationContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralInOperationContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterLiteralInOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitLiteralInOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitLiteralInOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ICSSParser.PLUS, 0); }
		public AdditionContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		return operation(0);
	}

	private OperationContext operation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperationContext _localctx = new OperationContext(_ctx, _parentState);
		OperationContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_operation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PIXELSIZE:
			case PERCENTAGE:
			case SCALAR:
			case COLOR:
				{
				_localctx = new LiteralInOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(215);
				literal();
				}
				break;
			case CAPITAL_IDENT:
				{
				_localctx = new VariableInOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				variableReference();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(228);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(219);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(220);
						match(MUL);
						setState(221);
						operation(4);
						}
						break;
					case 2:
						{
						_localctx = new AdditionContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(222);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(223);
						match(PLUS);
						setState(224);
						operation(3);
						}
						break;
					case 3:
						{
						_localctx = new InversiveAdditionContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(225);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(226);
						match(MIN);
						setState(227);
						operation(2);
						}
						break;
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PropertyContext extends ParserRuleContext {
		public TerminalNode LOWER_IDENT() { return getToken(ICSSParser.LOWER_IDENT, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(LOWER_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PixelLiteralContext extends LiteralContext {
		public TerminalNode PIXELSIZE() { return getToken(ICSSParser.PIXELSIZE, 0); }
		public PixelLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPixelLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPixelLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPixelLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScalarLiteralContext extends LiteralContext {
		public TerminalNode SCALAR() { return getToken(ICSSParser.SCALAR, 0); }
		public ScalarLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterScalarLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitScalarLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitScalarLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PercentageLiteralContext extends LiteralContext {
		public TerminalNode PERCENTAGE() { return getToken(ICSSParser.PERCENTAGE, 0); }
		public PercentageLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPercentageLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPercentageLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPercentageLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorLiteralContext extends LiteralContext {
		public TerminalNode COLOR() { return getToken(ICSSParser.COLOR, 0); }
		public ColorLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterColorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitColorLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitColorLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_literal);
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PIXELSIZE:
				_localctx = new PixelLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(PIXELSIZE);
				}
				break;
			case PERCENTAGE:
				_localctx = new PercentageLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(PERCENTAGE);
				}
				break;
			case SCALAR:
				_localctx = new ScalarLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				match(SCALAR);
				}
				break;
			case COLOR:
				_localctx = new ColorLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				match(COLOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorContext extends ParserRuleContext {
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
	 
		public SelectorContext() { }
		public void copyFrom(SelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdSelectorContext extends SelectorContext {
		public TerminalNode ID_IDENT() { return getToken(ICSSParser.ID_IDENT, 0); }
		public IdSelectorContext(SelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterIdSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitIdSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitIdSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TagSelectorContext extends SelectorContext {
		public TerminalNode LOWER_IDENT() { return getToken(ICSSParser.LOWER_IDENT, 0); }
		public TagSelectorContext(SelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterTagSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitTagSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitTagSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassSelectorContext extends SelectorContext {
		public TerminalNode CLASS_IDENT() { return getToken(ICSSParser.CLASS_IDENT, 0); }
		public ClassSelectorContext(SelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterClassSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitClassSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitClassSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_selector);
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOWER_IDENT:
				_localctx = new TagSelectorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(LOWER_IDENT);
				}
				break;
			case CLASS_IDENT:
				_localctx = new ClassSelectorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(CLASS_IDENT);
				}
				break;
			case ID_IDENT:
				_localctx = new IdSelectorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				match(ID_IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableReferenceContext extends ParserRuleContext {
		public TerminalNode CAPITAL_IDENT() { return getToken(ICSSParser.CAPITAL_IDENT, 0); }
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(CAPITAL_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return operation_sempred((OperationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean operation_sempred(OperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23\u00fb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3"+
		"\4\6\4C\n\4\r\4\16\4D\3\4\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4"+
		"\6\4R\n\4\r\4\16\4S\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4a\n\4\f\4\16\4d\13\4\3\4\7\4g\n\4\f\4\16\4j\13\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4q\n\4\f\4\16\4t\13\4\3\4\7\4w\n\4\f\4\16\4z\13\4\3\4\6\4}\n\4\r\4"+
		"\16\4~\3\4\3\4\3\4\3\4\3\4\7\4\u0086\n\4\f\4\16\4\u0089\13\4\3\4\6\4\u008c"+
		"\n\4\r\4\16\4\u008d\3\4\7\4\u0091\n\4\f\4\16\4\u0094\13\4\3\4\3\4\3\4"+
		"\3\4\3\4\6\4\u009b\n\4\r\4\16\4\u009c\3\4\7\4\u00a0\n\4\f\4\16\4\u00a3"+
		"\13\4\3\4\7\4\u00a6\n\4\f\4\16\4\u00a9\13\4\3\4\3\4\3\4\3\4\3\4\6\4\u00b0"+
		"\n\4\r\4\16\4\u00b1\3\4\7\4\u00b5\n\4\f\4\16\4\u00b8\13\4\3\4\7\4\u00bb"+
		"\n\4\f\4\16\4\u00be\13\4\3\4\3\4\5\4\u00c2\n\4\3\5\3\5\5\5\u00c6\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00d2\n\6\3\7\3\7\3\7\5\7\u00d7"+
		"\n\7\3\b\3\b\3\b\5\b\u00dc\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b"+
		"\u00e7\n\b\f\b\16\b\u00ea\13\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u00f2\n\n\3"+
		"\13\3\13\3\13\5\13\u00f7\n\13\3\f\3\f\3\f\2\3\16\r\2\4\6\b\n\f\16\20\22"+
		"\24\26\2\2\2\u011a\2\33\3\2\2\2\4\36\3\2\2\2\6\u00c1\3\2\2\2\b\u00c5\3"+
		"\2\2\2\n\u00d1\3\2\2\2\f\u00d6\3\2\2\2\16\u00db\3\2\2\2\20\u00eb\3\2\2"+
		"\2\22\u00f1\3\2\2\2\24\u00f6\3\2\2\2\26\u00f8\3\2\2\2\30\32\5\b\5\2\31"+
		"\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35"+
		"\33\3\2\2\2\36\37\5\26\f\2\37 \7\n\2\2 !\5\f\7\2!\"\7\5\2\2\"\5\3\2\2"+
		"\2#$\5\24\13\2$(\7\3\2\2%\'\5\n\6\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3"+
		"\2\2\2).\3\2\2\2*(\3\2\2\2+-\5\4\3\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2."+
		"/\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\4\2\2\62\u00c2\3\2\2\2\63\64"+
		"\5\24\13\2\648\7\3\2\2\65\67\5\n\6\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2"+
		"\2\289\3\2\2\29>\3\2\2\2:8\3\2\2\2;=\5\4\3\2<;\3\2\2\2=@\3\2\2\2><\3\2"+
		"\2\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2AC\5\6\4\2BA\3\2\2\2CD\3\2\2\2DB\3\2"+
		"\2\2DE\3\2\2\2EF\3\2\2\2FG\7\4\2\2G\u00c2\3\2\2\2HI\5\24\13\2IM\7\3\2"+
		"\2JL\5\n\6\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NQ\3\2\2\2OM\3\2\2"+
		"\2PR\5\6\4\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TX\3\2\2\2UW\5\4\3"+
		"\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\4"+
		"\2\2\\\u00c2\3\2\2\2]^\5\24\13\2^b\7\3\2\2_a\5\4\3\2`_\3\2\2\2ad\3\2\2"+
		"\2b`\3\2\2\2bc\3\2\2\2ch\3\2\2\2db\3\2\2\2eg\5\n\6\2fe\3\2\2\2gj\3\2\2"+
		"\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\4\2\2l\u00c2\3\2\2\2mn"+
		"\5\24\13\2nr\7\3\2\2oq\5\4\3\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2"+
		"sx\3\2\2\2tr\3\2\2\2uw\5\n\6\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2"+
		"y|\3\2\2\2zx\3\2\2\2{}\5\6\4\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2"+
		"\2\2\177\u0080\3\2\2\2\u0080\u0081\7\4\2\2\u0081\u00c2\3\2\2\2\u0082\u0083"+
		"\5\24\13\2\u0083\u0087\7\3\2\2\u0084\u0086\5\4\3\2\u0085\u0084\3\2\2\2"+
		"\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008b"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\6\4\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0092\3\2"+
		"\2\2\u008f\u0091\5\n\6\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0095\u0096\7\4\2\2\u0096\u00c2\3\2\2\2\u0097\u0098\5\24\13\2\u0098"+
		"\u009a\7\3\2\2\u0099\u009b\5\6\4\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a1\3\2\2\2\u009e"+
		"\u00a0\5\n\6\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a7\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a6\5\4\3\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa"+
		"\u00ab\7\4\2\2\u00ab\u00c2\3\2\2\2\u00ac\u00ad\5\24\13\2\u00ad\u00af\7"+
		"\3\2\2\u00ae\u00b0\5\6\4\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b6\3\2\2\2\u00b3\u00b5\5\4"+
		"\3\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00bc\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\5\n"+
		"\6\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\4"+
		"\2\2\u00c0\u00c2\3\2\2\2\u00c1#\3\2\2\2\u00c1\63\3\2\2\2\u00c1H\3\2\2"+
		"\2\u00c1]\3\2\2\2\u00c1m\3\2\2\2\u00c1\u0082\3\2\2\2\u00c1\u0097\3\2\2"+
		"\2\u00c1\u00ac\3\2\2\2\u00c2\7\3\2\2\2\u00c3\u00c6\5\6\4\2\u00c4\u00c6"+
		"\5\4\3\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\t\3\2\2\2\u00c7"+
		"\u00c8\5\20\t\2\u00c8\u00c9\7\6\2\2\u00c9\u00ca\5\f\7\2\u00ca\u00cb\7"+
		"\5\2\2\u00cb\u00d2\3\2\2\2\u00cc\u00cd\5\20\t\2\u00cd\u00ce\7\6\2\2\u00ce"+
		"\u00cf\5\26\f\2\u00cf\u00d0\7\5\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00c7\3"+
		"\2\2\2\u00d1\u00cc\3\2\2\2\u00d2\13\3\2\2\2\u00d3\u00d7\5\22\n\2\u00d4"+
		"\u00d7\5\26\f\2\u00d5\u00d7\5\16\b\2\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3"+
		"\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\r\3\2\2\2\u00d8\u00d9\b\b\1\2\u00d9\u00dc"+
		"\5\22\n\2\u00da\u00dc\5\26\f\2\u00db\u00d8\3\2\2\2\u00db\u00da\3\2\2\2"+
		"\u00dc\u00e8\3\2\2\2\u00dd\u00de\f\5\2\2\u00de\u00df\7\t\2\2\u00df\u00e7"+
		"\5\16\b\6\u00e0\u00e1\f\4\2\2\u00e1\u00e2\7\7\2\2\u00e2\u00e7\5\16\b\5"+
		"\u00e3\u00e4\f\3\2\2\u00e4\u00e5\7\b\2\2\u00e5\u00e7\5\16\b\4\u00e6\u00dd"+
		"\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\17\3\2\2\2\u00ea\u00e8\3\2\2"+
		"\2\u00eb\u00ec\7\21\2\2\u00ec\21\3\2\2\2\u00ed\u00f2\7\13\2\2\u00ee\u00f2"+
		"\7\f\2\2\u00ef\u00f2\7\r\2\2\u00f0\u00f2\7\16\2\2\u00f1\u00ed\3\2\2\2"+
		"\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\23"+
		"\3\2\2\2\u00f3\u00f7\7\21\2\2\u00f4\u00f7\7\20\2\2\u00f5\u00f7\7\17\2"+
		"\2\u00f6\u00f3\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\25"+
		"\3\2\2\2\u00f8\u00f9\7\22\2\2\u00f9\27\3\2\2\2\"\33(.8>DMSXbhrx~\u0087"+
		"\u008d\u0092\u009c\u00a1\u00a7\u00b1\u00b6\u00bc\u00c1\u00c5\u00d1\u00d6"+
		"\u00db\u00e6\u00e8\u00f1\u00f6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}