
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class IfStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Expression expression; Boolean expressionIsComposed = true;
			
			Statement thenStatement; Boolean thenStatementIsComposed = true;
			
			Statement elseStatement; Boolean elseStatementIsComposed = true;
			
			
			public IfStatement(){ }
			
			
			public IfStatement(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression expression,				Statement thenStatement,				Statement elseStatement ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.expression = expression ;
				this.thenStatement = thenStatement ;
				this.elseStatement = elseStatement ;
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
			
			
			
			
			
			public void setExpression(Expression expression) {
				this.expression = expression;
			}
				
			public Expression getExpression() {
				return expression;
			}
			
			public void setThenStatement(Statement thenStatement) {
				this.thenStatement = thenStatement;
			}
				
			public Statement getThenStatement() {
				return thenStatement;
			}
			
			public void setElseStatement(Statement elseStatement) {
				this.elseStatement = elseStatement;
			}
				
			public Statement getElseStatement() {
				return elseStatement;
			}
			
		}
	