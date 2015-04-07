
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class EnhancedForStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Statement body; Boolean bodyIsComposed = true;
			
			Expression expression; Boolean expressionIsComposed = true;
			
			SingleVariableDeclaration parameter; Boolean parameterIsComposed = true;
			
			
			public EnhancedForStatement(){ }
			
			
			public EnhancedForStatement(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Statement body,				Expression expression,				SingleVariableDeclaration parameter ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.body = body ;
				this.expression = expression ;
				this.parameter = parameter ;
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
			
			
			
			
			
			public void setBody(Statement body) {
				this.body = body;
			}
				
			public Statement getBody() {
				return body;
			}
			
			public void setExpression(Expression expression) {
				this.expression = expression;
			}
				
			public Expression getExpression() {
				return expression;
			}
			
			public void setParameter(SingleVariableDeclaration parameter) {
				this.parameter = parameter;
			}
				
			public SingleVariableDeclaration getParameter() {
				return parameter;
			}
			
		}
	