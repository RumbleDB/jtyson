// Generated from tyson.g4 by ANTLR 4.7.1
package antlr_generated_files;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tysonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, STRING=13, DECIMAL=14, DOUBLE=15, INT=16, 
		WS=17;
	public static final int
		RULE_tyson = 0, RULE_annotatedValue = 1, RULE_obj = 2, RULE_pair = 3, 
		RULE_array = 4, RULE_number = 5, RULE_value = 6;
	public static final String[] ruleNames = {
		"tyson", "annotatedValue", "obj", "pair", "array", "number", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "','", "'}'", "':'", "'['", "']'", "'-'", "'true'", 
		"'false'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "STRING", "DECIMAL", "DOUBLE", "INT", "WS"
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
	public String getGrammarFileName() { return "tyson.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tysonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TysonContext extends ParserRuleContext {
		public AnnotatedValueContext annotatedValue() {
			return getRuleContext(AnnotatedValueContext.class,0);
		}
		public TysonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyson; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).enterTyson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).exitTyson(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tysonVisitor ) return ((tysonVisitor<? extends T>)visitor).visitTyson(this);
			else return visitor.visitChildren(this);
		}
	} 

	public final TysonContext tyson() throws RecognitionException {
		TysonContext _localctx = new TysonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tyson);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			annotatedValue();
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

	public static class AnnotatedValueContext extends ParserRuleContext {
		public Token typeName;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(tysonParser.STRING, 0); }
		public AnnotatedValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).enterAnnotatedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).exitAnnotatedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tysonVisitor ) return ((tysonVisitor<? extends T>)visitor).visitAnnotatedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotatedValueContext annotatedValue() throws RecognitionException {
		AnnotatedValueContext _localctx = new AnnotatedValueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_annotatedValue);
		try {
			setState(21);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__6:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case STRING:
			case DECIMAL:
			case DOUBLE:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				value();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				match(T__0);
				setState(18);
				((AnnotatedValueContext)_localctx).typeName = match(STRING);
				setState(19);
				match(T__1);
				setState(20);
				value();
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

	public static class ObjContext extends ParserRuleContext {
		public PairContext pair;
		public List<PairContext> pairlst = new ArrayList<PairContext>();
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tysonVisitor ) return ((tysonVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_obj);
		int _la;
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(T__2);
				setState(24);
				((ObjContext)_localctx).pair = pair();
				((ObjContext)_localctx).pairlst.add(((ObjContext)_localctx).pair);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{ 
					{
					setState(25);
					match(T__3);
					setState(26);
					((ObjContext)_localctx).pair = pair();
					((ObjContext)_localctx).pairlst.add(((ObjContext)_localctx).pair);
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(T__2);
				setState(35);
				match(T__4);
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

	public static class PairContext extends ParserRuleContext {
		public Token key;
		public AnnotatedValueContext annotatedValue() {
			return getRuleContext(AnnotatedValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(tysonParser.STRING, 0); }
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).exitPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tysonVisitor ) return ((tysonVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((PairContext)_localctx).key = match(STRING);
			setState(39);
			match(T__5);
			setState(40);
			annotatedValue();
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

	public static class ArrayContext extends ParserRuleContext {
		public AnnotatedValueContext annotatedValue;
		public List<AnnotatedValueContext> arlst = new ArrayList<AnnotatedValueContext>();
		public List<AnnotatedValueContext> annotatedValue() {
			return getRuleContexts(AnnotatedValueContext.class);
		}
		public AnnotatedValueContext annotatedValue(int i) {
			return getRuleContext(AnnotatedValueContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tysonVisitor ) return ((tysonVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_array);
		int _la;
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__6);
				setState(43);
				((ArrayContext)_localctx).annotatedValue = annotatedValue();
				((ArrayContext)_localctx).arlst.add(((ArrayContext)_localctx).annotatedValue);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(44);
					match(T__3);
					setState(45);
					((ArrayContext)_localctx).annotatedValue = annotatedValue();
					((ArrayContext)_localctx).arlst.add(((ArrayContext)_localctx).annotatedValue);
					}
					}
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(51);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(T__6);
				setState(54);
				match(T__7);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(tysonParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(tysonParser.DECIMAL, 0); }
		public TerminalNode DOUBLE() { return getToken(tysonParser.DOUBLE, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tysonVisitor ) return ((tysonVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_number);
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(57);
					match(T__8);
					}
				}

				setState(60);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(61);
					match(T__8);
					}
				}

				setState(64);
				match(DECIMAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(65);
					match(T__8);
					}
				}

				setState(68);
				match(DOUBLE);
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

	public static class ValueContext extends ParserRuleContext {
		public Token str;
		public TerminalNode STRING() { return getToken(tysonParser.STRING, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tysonListener ) ((tysonListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tysonVisitor ) return ((tysonVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		} 
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((ValueContext)_localctx).str = match(STRING);
				}
				break;
			case T__8:
			case DECIMAL:
			case DOUBLE:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				number();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				obj();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				array();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				match(T__11);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23S\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\30\n\3\3\4\3\4\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3\4\3\4\3\4\3\4"+
		"\5\4\'\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\61\n\6\f\6\16\6\64\13\6"+
		"\3\6\3\6\3\6\3\6\5\6:\n\6\3\7\5\7=\n\7\3\7\3\7\5\7A\n\7\3\7\3\7\5\7E\n"+
		"\7\3\7\5\7H\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bQ\n\b\3\b\2\2\t\2\4\6\b"+
		"\n\f\16\2\2\2[\2\20\3\2\2\2\4\27\3\2\2\2\6&\3\2\2\2\b(\3\2\2\2\n9\3\2"+
		"\2\2\fG\3\2\2\2\16P\3\2\2\2\20\21\5\4\3\2\21\3\3\2\2\2\22\30\5\16\b\2"+
		"\23\24\7\3\2\2\24\25\7\17\2\2\25\26\7\4\2\2\26\30\5\16\b\2\27\22\3\2\2"+
		"\2\27\23\3\2\2\2\30\5\3\2\2\2\31\32\7\5\2\2\32\37\5\b\5\2\33\34\7\6\2"+
		"\2\34\36\5\b\5\2\35\33\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 "+
		"\"\3\2\2\2!\37\3\2\2\2\"#\7\7\2\2#\'\3\2\2\2$%\7\5\2\2%\'\7\7\2\2&\31"+
		"\3\2\2\2&$\3\2\2\2\'\7\3\2\2\2()\7\17\2\2)*\7\b\2\2*+\5\4\3\2+\t\3\2\2"+
		"\2,-\7\t\2\2-\62\5\4\3\2./\7\6\2\2/\61\5\4\3\2\60.\3\2\2\2\61\64\3\2\2"+
		"\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7\n\2"+
		"\2\66:\3\2\2\2\678\7\t\2\28:\7\n\2\29,\3\2\2\29\67\3\2\2\2:\13\3\2\2\2"+
		";=\7\13\2\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>H\7\22\2\2?A\7\13\2\2@?\3\2"+
		"\2\2@A\3\2\2\2AB\3\2\2\2BH\7\20\2\2CE\7\13\2\2DC\3\2\2\2DE\3\2\2\2EF\3"+
		"\2\2\2FH\7\21\2\2G<\3\2\2\2G@\3\2\2\2GD\3\2\2\2H\r\3\2\2\2IQ\7\17\2\2"+
		"JQ\5\f\7\2KQ\5\6\4\2LQ\5\n\6\2MQ\7\f\2\2NQ\7\r\2\2OQ\7\16\2\2PI\3\2\2"+
		"\2PJ\3\2\2\2PK\3\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q\17\3\2"+
		"\2\2\f\27\37&\629<@DGP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}