
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ConditionalExpression  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Expression elseExpression; Boolean elseExpressionIsComposed = true;
			
			Expression expression; Boolean expressionIsComposed = true;
			
			Expression thenExpression; Boolean thenExpressionIsComposed = true;
			
			
			public ConditionalExpression(){ }
			
			
			public ConditionalExpression(
				String id,				
				
				Comment[] comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression elseExpression,				Expression expression,				Expression thenExpression ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.elseExpression = elseExpression ;
				this.expression = expression ;
				this.thenExpression = thenExpression ;
			}
			
			
			
			public String getId() {
   				return id;
			}

			public void setId(String id) {
   				this.id = id;
			}
			
			public String getTrgId() {
   				return trgId;
			}

			public void setTrgId(String trgId) {
   				this.trgId = trgId;
			}
			
			
			
			
			
			public void setElseExpression(Expression elseExpression) {
				this.elseExpression = elseExpression;
			}
				
			public Expression getElseExpression() {
				return elseExpression;
			}
			
			public void setExpression(Expression expression) {
				this.expression = expression;
			}
				
			public Expression getExpression() {
				return expression;
			}
			
			public void setThenExpression(Expression thenExpression) {
				this.thenExpression = thenExpression;
			}
				
			public Expression getThenExpression() {
				return thenExpression;
			}
			
		}
	