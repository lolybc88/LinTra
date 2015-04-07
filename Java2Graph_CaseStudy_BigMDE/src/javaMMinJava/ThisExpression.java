
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ThisExpression  extends AbstractTypeQualifiedExpression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			
			public ThisExpression(){ }
			
			
			public ThisExpression(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				TypeAccess qualifier ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				qualifier
);
				
				this.id = id;
				
				
				
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
			
			
			
			
			
		}
	