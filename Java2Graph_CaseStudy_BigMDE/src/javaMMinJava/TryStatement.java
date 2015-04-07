
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class TryStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Block body; Boolean bodyIsComposed = true;
			
			Block finally_; Boolean finallyIsComposed = true;
			
			CatchClause catchClauses; Boolean catchClausesIsComposed = true;
			
			
			public TryStatement(){ }
			
			
			public TryStatement(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Block body,				Block finally_,				CatchClause catchClauses ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.body = body ;
				this.finally_ = finally_ ;
				this.catchClauses = catchClauses ;
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
			
			
			
			
			
			public void setBody(Block body) {
				this.body = body;
			}
				
			public Block getBody() {
				return body;
			}
			
			public void setFinally(Block finally_) {
				this.finally_ = finally_;
			}
				
			public Block getFinally() {
				return finally_;
			}
			
			public void setCatchClauses(CatchClause catchClauses) {
				this.catchClauses = catchClauses;
			}
				
			public CatchClause getCatchClauses() {
				return catchClauses;
			}
			
		}
	