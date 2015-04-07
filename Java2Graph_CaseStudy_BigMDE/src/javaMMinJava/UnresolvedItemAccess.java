
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class UnresolvedItemAccess  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			UnresolvedItem element; Boolean elementIsComposed = false;
			
			ASTNode qualifier; Boolean qualifierIsComposed = true;
			
			
			public UnresolvedItemAccess(){ }
			
			
			public UnresolvedItemAccess(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				UnresolvedItem element,				ASTNode qualifier ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.element = element ;
				this.qualifier = qualifier ;
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
			
			
			
			
			
			public void setElement(UnresolvedItem element) {
				this.element = element;
			}
				
			public UnresolvedItem getElement() {
				return element;
			}
			
			public void setQualifier(ASTNode qualifier) {
				this.qualifier = qualifier;
			}
				
			public ASTNode getQualifier() {
				return qualifier;
			}
			
		}
	