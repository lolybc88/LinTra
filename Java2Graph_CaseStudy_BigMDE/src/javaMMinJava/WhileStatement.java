
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class WhileStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Expression expression; Boolean expressionIsComposed = true;
			
			Statement body; Boolean bodyIsComposed = true;
			
			
			public WhileStatement(){ }
			
			
			public WhileStatement(
				String id,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression expression,				Statement body ){
				
				super(	
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.expression = expression ;
				this.body = body ;
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
			
			public void setBody(Statement body) {
				this.body = body;
			}
				
			public Statement getBody() {
				return body;
			}
			
		}
	