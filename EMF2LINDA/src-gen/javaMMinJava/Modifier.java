
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class Modifier  extends ASTNode implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			String visibility;
			String inheritance;
			Boolean static;
			Boolean transient;
			Boolean volatile;
			Boolean native;
			Boolean strictfp;
			Boolean synchronized;
			
			
			BodyDeclaration bodyDeclaration; Boolean bodyDeclarationIsComposed = false;
			
			SingleVariableDeclaration singleVariableDeclaration; Boolean singleVariableDeclarationIsComposed = false;
			
			VariableDeclarationStatement variableDeclarationStatement; Boolean variableDeclarationStatementIsComposed = false;
			
			VariableDeclarationExpression variableDeclarationExpression; Boolean variableDeclarationExpressionIsComposed = false;
			
			
			public Modifier(){ }
			
			
			public Modifier(
				String id,				
				String visibility,				String inheritance,				Boolean static,				Boolean transient,				Boolean volatile,				Boolean native,				Boolean strictfp,				Boolean synchronized
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				BodyDeclaration bodyDeclaration,				SingleVariableDeclaration singleVariableDeclaration,				VariableDeclarationStatement variableDeclarationStatement,				VariableDeclarationExpression variableDeclarationExpression ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.visibility = visibility ;
				this.inheritance = inheritance ;
				this.static = static ;
				this.transient = transient ;
				this.volatile = volatile ;
				this.native = native ;
				this.strictfp = strictfp ;
				this.synchronized = synchronized ;
				
				this.bodyDeclaration = bodyDeclaration ;
				this.singleVariableDeclaration = singleVariableDeclaration ;
				this.variableDeclarationStatement = variableDeclarationStatement ;
				this.variableDeclarationExpression = variableDeclarationExpression ;
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
			
			
			
			public void setVisibility(String visibility) {
				this.visibility = visibility;
			}
				
			public String getVisibility() {
				return visibility;
			}
			
			public void setInheritance(String inheritance) {
				this.inheritance = inheritance;
			}
				
			public String getInheritance() {
				return inheritance;
			}
			
			public void setStatic(Boolean static) {
				this.static = static;
			}
				
			public Boolean getStatic() {
				return static;
			}
			
			public void setTransient(Boolean transient) {
				this.transient = transient;
			}
				
			public Boolean getTransient() {
				return transient;
			}
			
			public void setVolatile(Boolean volatile) {
				this.volatile = volatile;
			}
				
			public Boolean getVolatile() {
				return volatile;
			}
			
			public void setNative(Boolean native) {
				this.native = native;
			}
				
			public Boolean getNative() {
				return native;
			}
			
			public void setStrictfp(Boolean strictfp) {
				this.strictfp = strictfp;
			}
				
			public Boolean getStrictfp() {
				return strictfp;
			}
			
			public void setSynchronized(Boolean synchronized) {
				this.synchronized = synchronized;
			}
				
			public Boolean getSynchronized() {
				return synchronized;
			}
			
			
			
			public void setBodyDeclaration(BodyDeclaration bodyDeclaration) {
				this.bodyDeclaration = bodyDeclaration;
			}
				
			public BodyDeclaration getBodyDeclaration() {
				return bodyDeclaration;
			}
			
			public void setSingleVariableDeclaration(SingleVariableDeclaration singleVariableDeclaration) {
				this.singleVariableDeclaration = singleVariableDeclaration;
			}
				
			public SingleVariableDeclaration getSingleVariableDeclaration() {
				return singleVariableDeclaration;
			}
			
			public void setVariableDeclarationStatement(VariableDeclarationStatement variableDeclarationStatement) {
				this.variableDeclarationStatement = variableDeclarationStatement;
			}
				
			public VariableDeclarationStatement getVariableDeclarationStatement() {
				return variableDeclarationStatement;
			}
			
			public void setVariableDeclarationExpression(VariableDeclarationExpression variableDeclarationExpression) {
				this.variableDeclarationExpression = variableDeclarationExpression;
			}
				
			public VariableDeclarationExpression getVariableDeclarationExpression() {
				return variableDeclarationExpression;
			}
			
		}
	