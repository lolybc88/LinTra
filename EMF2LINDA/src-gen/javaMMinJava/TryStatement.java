
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class TryStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Block body; Boolean bodyIsComposed = true;
			
			Block finally; Boolean finallyIsComposed = true;
			
			CatchClause catchClauses; Boolean catchClausesIsComposed = true;
			
			
			public TryStatement(){ }
			
			
			public TryStatement(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Block body,				Block finally,				CatchClause catchClauses ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.body = body ;
				this.finally = finally ;
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
			
			public void setFinally(Block finally) {
				this.finally = finally;
			}
				
			public Block getFinally() {
				return finally;
			}
			
			public void setCatchClauses(CatchClause catchClauses) {
				this.catchClauses = catchClauses;
			}
				
			public CatchClause getCatchClauses() {
				return catchClauses;
			}
			
		}
	