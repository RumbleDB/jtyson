package org.rumbledb.tyson;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.rumbledb.tyson.antlr.generated.tysonBaseVisitor;
import org.rumbledb.tyson.antlr.generated.tysonParser;

/**
 * Visitor for recursively building a <code>TysonInstance</code> from a <code>TYSON</code> text.
 */
public class JavaTysonVisitor extends tysonBaseVisitor{
	
	
	 
	/**
	 * Method for visiting the topmost <code>TYSON</code> value.
	 */
	public TysonInstance visitTyson(tysonParser.TysonContext ctx) { 
		TysonInstance parentTy = visitAnnotatedValue(ctx.annotatedValue());

		return parentTy;	
	}
	
	/**
	 * Visits a (possibly) annotated <code>TYSON</code> context and recursively builds the {@link TysonInstance}.
	 * If there is no annotation, it builds the <code>TysonInstance</code> with its implicit type.
	 * If there is a type annotation present, checks that the annotated type matches the parsed value
	 * and throws a RuntimeException if this is not the case.
	 * For quoted values: If the value is quoted, but the type-annotation specifies a built-in type,
	 * the Visitor checks if the quoted value belongs to the lexical space of the annotated type.
	 * If this is true, it builds a <code>TysonInstance</code> corresponding to the annotated type.
	 * If the annotated type name is not any of the <code>TYSON</code> built-in types, checks the implicit type
	 * of the parsed value. 
	 * If this is any of the atomic types, constructs a {@link TysonUserDefinedAtomic} with the given user-defined name.
	 * If this is an array type, constructs a {@link TysonUserDefinedArray} with the given user-defined name.
	 * If this is an object type, constructs a {@link TysonUserDefinedObject} with the given user-defined name.
	 * The Visitor does not allow nested user-defined types.
	 * 
	 */
	public TysonInstance visitAnnotatedValue(tysonParser.AnnotatedValueContext ctx) { 
		
		TysonInstance ty = visitValue(ctx.value());
		
		if(ctx.typeName != null) {
			String typeName = ctx.typeName.getText();

		List<String> builtinTypes = Arrays.asList("\"string\"", "\"integer\"", "\"decimal\"", "\"double\"", "\"boolean\"", "\"null\"", "\"object\"", "\"array\"");

		if(builtinTypes.contains(typeName.intern())) {
			
			if(typeName.intern().equals("\"array\"")) {

				if(ty.isArray()) {
					return ty;
				}
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
			else if(typeName.intern().equals("\"boolean\"")) {

				if(ty.isBoolean()) {
					return ty;
				}
				else if(ty.isString() && ty.getStringValue().equals("true")) {
					return TysonFactory.getInstance().createBoolean(true);
				}
				else if(ty.isString() && ty.getStringValue().equals("false")) {
					return TysonFactory.getInstance().createBoolean(false);
				}
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
			else if(typeName.intern().equals("\"decimal\"")) {
				if(ty.isDecimal()) {
					return ty;
				}
				else if(ty.isString()) {
					
						if(! (ty.getStringValue().contains("e")||ty.getStringValue().contains("E"))) {
							
							try {
								BigDecimal decimalFromString = new BigDecimal(ty.getStringValue());
								return TysonFactory.getInstance().createDecimal(decimalFromString);
							} catch(NumberFormatException e) {
								throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
							}
							
						}	
						else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");

				} else if(ty.isInteger()) {
					BigDecimal d = new BigDecimal(ty.getIntegerValue());
					return TysonFactory.getInstance().createDecimal(d);
				}
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
			else if(typeName.intern().equals("\"double\"")) {
				if(ty.isDouble()) {
					return ty;
				}
				else if(ty.isString()) {

					if (ty.getStringValue().equals("NaN")) {
							
							return TysonFactory.getInstance().createDouble(Double.NaN);
							
						} else if (ty.getStringValue().equals("+INF")) {
							
							return TysonFactory.getInstance().createDouble(Double.POSITIVE_INFINITY);
							
						} else if (ty.getStringValue().equals("-INF")) {
							
							return TysonFactory.getInstance().createDouble(Double.NEGATIVE_INFINITY);
							
						} else if (!ty.getStringValue().contains(".")){
							
							try {
								double doubleFromString = Double.parseDouble(ty.getStringValue());
								return TysonFactory.getInstance().createDouble(doubleFromString);
							} catch (NumberFormatException e) {
								throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
							}
						}

						else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
					} else if(ty.isInteger()) {
						double d = ty.getIntegerValue();
						return TysonFactory.getInstance().createDouble(d);
					}
				
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
			else if(typeName.intern().equals("\"integer\"")) {
				if(ty.isInteger()) {
					return ty;
				}
				else if(ty.isString()) {
					try {
						String str = ty.getStringValue();
						Integer integerFromString = Integer.valueOf(str);
						return TysonFactory.getInstance().createInteger(integerFromString);
					} catch(Exception e) {
						throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
					}
				}
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
			else if(typeName.intern().equals("\"null\"")) {
				if(ty.isNull()) {
					return ty;
				}
				else if(ty.isString() && ty.getStringValue().equals("null")) {
					return TysonFactory.getInstance().createNull();
				}
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
			else if(typeName.intern().equals("\"object\"")) {
				if(ty.isObject()) {
					return ty;
				}
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
			else if(typeName.intern().equals("\"string\"")) {
				if(ty.isString()) {
					return ty;
				}
				else if(ty.isBoolean()) {
					return TysonFactory.getInstance().createString(ty.getBooleanValue()? "true":"false");
				}
				else if(ty.isNull()) {
					return TysonFactory.getInstance().createString("null");
				}
				else if(ty.isInteger()) {
					return TysonFactory.getInstance().createString(String.valueOf(ty.getIntegerValue()));
				}
				else if(ty.isDouble()) {
					return TysonFactory.getInstance().createString(String.valueOf(ty.getDoubleValue()));
				}
				else if(ty.isDecimal()) {
					return TysonFactory.getInstance().createString(ty.getDecimalValue().toEngineeringString());
				} 
				else throw new RuntimeException("Annotated type "+ typeName.intern() + " does not match instanciated type");
			}
		}
	
		
		//in the case nothing matched, we have a user defined type that we must create
		if(ty.isBoolean() || ty.isInteger() || ty.isDecimal() || ty.isDouble() || ty.isNull() || ty.isString()) {
			return TysonFactory.getInstance().createUserDefinedAtomic(typeName, ty);
		} 
		else if(ty.isArray()) {
			return TysonFactory.getInstance().createUserDefinedArray(typeName, ty);
		}
		else if (ty.isObject()) {
			return TysonFactory.getInstance().createUserDefinedObject(typeName, ty);
		}
		else throw new RuntimeException("No nested userDefinedTypes are allowed");
		}
		return ty;
		
	}
	
	
	/**
	 * Visits a <code>TYSON</code> object-context and builds the specified {@link TysonObject}
	 * by adding <code>(key, value)</code>-pairs to the <code>TysonObject</code> where the <code>values</code>
	 * are recursively built by calling {@link visitPair}.
	 */
	public TysonObject visitObj(tysonParser.ObjContext ctx) { 
		
		TysonObject ty = TysonFactory.getInstance().createObject();
		int n = ctx.pairlst.size();
		
		for (int i = 0; i<n ; i++) {
			String key = ctx.pair(i).key.getText().toString();
			//to get rid of the leading and ending quotes in order to simplify key lookup:
			key = key.substring(1, key.length()-1);
			TysonInstance ti = visitPair(ctx.pair(i));
			ty.addPair(key, ti);
		}
		return ty;
			
	}
	
	
	/**
	 * Visits a <code>TYSON</code> pair-context and recursively builds up the <code>value</code>
	 * of a <code>(key, value)</code>-pair by calling {@link visitAnnotatedValue}
	 */
	public TysonInstance visitPair(tysonParser.PairContext ctx) { 
		
		TysonInstance ty = visitAnnotatedValue(ctx.annotatedValue());
		
		return ty;
		
	}
	
	
	 
	/**
	 * Visits a <code>TYSON</code> array-context and builds the specified {@link TysonArray} 
	 * by adding <code>TysonInstances</code> to the array created by calling {@link visitAnnotatedValue} 
	 * on the parsed array items.
	 */
	public TysonArray visitArray(tysonParser.ArrayContext ctx) { 
		TysonArray tarr = TysonFactory.getInstance().createArray();
		
		int n = ctx.arlst.size();
		
		
		for (int i = 0; i<n ; i++) {
			//visit each child node of the array and build its respective TysonInstance
			TysonInstance ti = visitAnnotatedValue(ctx.annotatedValue(i));
			tarr.appendElement(ti);
		}
		
		return tarr;
	}
	
	/**
	 * Visits a <code>TYSON</code> number-context and builds the specified {@link TysonInstance}.
	 * Depending on if the value was parsed as an INT, DECIMAL or DOUBLE as specified in the grammar,
	 * the corresponding {@link TysonInteger}, {@link TysonDecimal} or {@link TysonDouble} is created.
	 */
	public TysonInstance visitNumber(tysonParser.NumberContext ctx) {
		
		TysonInstance ty = null;
		
		if(!(ctx.INT()== null)) {
			ty = TysonFactory.getInstance().createInteger(Integer.parseInt(ctx.INT().getText()));
		}
		else if(!(ctx.DECIMAL()== null)) {
			BigDecimal BDecimal = new BigDecimal(ctx.DECIMAL().getText());
			ty = TysonFactory.getInstance().createDecimal(BDecimal);
		}
		else if(!(ctx.DOUBLE()== null)) {
			ty = TysonFactory.getInstance().createDouble(Double.parseDouble(ctx.DOUBLE().getText()));
		}
		return ty;
	}
	
	
	 
	/**
	 * Visits a <code>TYSON</code> value-context. Depending on how the value was parsed, 
	 * calls the appropriate function to visit this type and builds the {@link TysonInstance} accordingly.
	 * Builds a {@link TysonBoolean} directly, if the value was parsed as either "true" or "false" and
	 * builds a {@link TysonNull} directly, if the value was parsed as "null".
	 */
	public TysonInstance visitValue(tysonParser.ValueContext ctx) { 
		
		TysonInstance ty = null;
		
		if(!(ctx.STRING() == null)) {
			
			String str = ctx.STRING().getText();
			str = str.substring(1, str.length()-1);
			ty = TysonFactory.getInstance().createString(str);
			return ty;
		}
		else if (!(ctx.number() == null)) {
			ty = visitNumber(ctx.number());
			return ty;
		}
		else if (!(ctx.obj() == null)) {
			ty = visitObj(ctx.obj());
			return ty;
		}
		else if (!(ctx.array() == null)) {
			ty = visitArray(ctx.array());
			return ty;
		}
		else if (ctx.getText().intern().equals("true")) {
			ty = TysonFactory.getInstance().createBoolean(true);
			return ty;
		}
		else if (ctx.getText().intern().equals("false")) {
			ty = TysonFactory.getInstance().createBoolean(false);
			return ty;
		}
		else if (ctx.getText().intern().equals("null")) {
			ty = TysonFactory.getInstance().createNull();
			return ty;
		}
	
		return ty;
	}
	
	
	
	
}

