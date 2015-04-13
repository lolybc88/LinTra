
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class Modifier  extends ASTNode implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			String visibility;
			String inheritance;
			Boolean static_;
			Boolean transient_;
			Boolean volatile_;
			Boolean native_;
			Boolean strictfp_;
			Boolean synchronized_;
			
			
			BodyDeclaration bodyDeclaration; Boolean bodyDeclarationIsComposed = false;
			
			SingleVariableDeclaration singleVariableDeclaration; Boolean singleVariableDeclarationIsComposed = false;
			
			VariableDeclarationStatement variableDeclarationStatement; Boolean variableDeclarationStatementIsComposed = false;
			
			VariableDeclarationExpression variableDeclarationExpression; Boolean variableDeclarationExpressionIsComposed = false;
			
			
			public Modifier(){ }
			
			
			public Modifier(
				String id,				
				String visibility,				String inheritance,				Boolean static_,				Boolean transient_,				Boolean volatile_,				Boolean native_,				Boolean strictfp_,				Boolean synchronized_
				,
				Comment[] comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				BodyDeclaration bodyDeclaration,				SingleVariableDeclaration singleVariableDeclaration,				VariableDeclarationStatement variableDeclarationStatement,				VariableDeclarationExpression variableDeclarationExpression ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.visibility = visibility ;
				this.inheritance = inheritance ;
				this.static_ = static_ ;
				this.transient_ = transient_ ;
				this.volatile_ = volatile_ ;
				this.native_ = native_ ;
				this.strictfp_ = strictfp_ ;
				this.synchronized_ = synchronized_ ;
				
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
			
			public void setStatic(Boolean static_) {
				this.static_ = static_;
			}
				
			public Boolean getStatic() {
				return static_;
			}
			
			public void setTransient(Boolean transient_) {
				this.transient_ = transient_;
			}
				
			public Boolean getTransient() {
				return transient_;
			}
			
			public void setVolatile(Boolean volatile_) {
				this.volatile_ = volatile_;
			}
				
			public Boolean getVolatile() {
				return volatile_;
			}
			
			public void setNative(Boolean native_) {
				this.native_ = native_;
			}
				
			public Boolean getNative() {
				return native_;
			}
			
			public void setStrictfp(Boolean strictfp_) {
				this.strictfp_ = strictfp_;
			}
				
			public Boolean getStrictfp() {
				return strictfp_;
			}
			
			public void setSynchronized(Boolean synchronized_) {
				this.synchronized_ = synchronized_;
			}
				
			public Boolean getSynchronized() {
				return synchronized_;
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
	