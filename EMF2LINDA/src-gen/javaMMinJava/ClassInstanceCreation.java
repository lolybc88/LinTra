
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ClassInstanceCreation  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			AnonymousClassDeclaration anonymousClassDeclaration; Boolean anonymousClassDeclarationIsComposed = true;
			
			Expression expression; Boolean expressionIsComposed = true;
			
			TypeAccess type; Boolean typeIsComposed = true;
			
			
			public ClassInstanceCreation(){ }
			
			
			public ClassInstanceCreation(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				AbstractMethodDeclaration method,				Expression arguments,				TypeAccess typeArguments,				AnonymousClassDeclaration anonymousClassDeclaration,				Expression expression,				TypeAccess type ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				method
				,				arguments
				,				typeArguments
);
				
				this.id = id;
				
				
				
				this.anonymousClassDeclaration = anonymousClassDeclaration ;
				this.expression = expression ;
				this.type = type ;
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
			
			
			
			
			
			public void setAnonymousClassDeclaration(AnonymousClassDeclaration anonymousClassDeclaration) {
				this.anonymousClassDeclaration = anonymousClassDeclaration;
			}
				
			public AnonymousClassDeclaration getAnonymousClassDeclaration() {
				return anonymousClassDeclaration;
			}
			
			public void setExpression(Expression expression) {
				this.expression = expression;
			}
				
			public Expression getExpression() {
				return expression;
			}
			
			public void setType(TypeAccess type) {
				this.type = type;
			}
				
			public TypeAccess getType() {
				return type;
			}
			
		}
	