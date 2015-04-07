
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ForStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Expression expression; Boolean expressionIsComposed = true;
			
			Expression updaters; Boolean updatersIsComposed = true;
			
			Expression initializers; Boolean initializersIsComposed = true;
			
			Statement body; Boolean bodyIsComposed = true;
			
			
			public ForStatement(){ }
			
			
			public ForStatement(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression expression,				Expression updaters,				Expression initializers,				Statement body ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.expression = expression ;
				this.updaters = updaters ;
				this.initializers = initializers ;
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
			
			public void setUpdaters(Expression updaters) {
				this.updaters = updaters;
			}
				
			public Expression getUpdaters() {
				return updaters;
			}
			
			public void setInitializers(Expression initializers) {
				this.initializers = initializers;
			}
				
			public Expression getInitializers() {
				return initializers;
			}
			
			public void setBody(Statement body) {
				this.body = body;
			}
				
			public Statement getBody() {
				return body;
			}
			
		}
	