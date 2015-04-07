
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public abstract class ASTNode  implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			
			
			
			
			
			Comment comments; Boolean commentsIsComposed = true;
			
			CompilationUnit originalCompilationUnit; Boolean originalCompilationUnitIsComposed = false;
			
			ClassFile originalClassFile; Boolean originalClassFileIsComposed = false;
			
			
			public ASTNode(){ }
			
			
			public ASTNode(
				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile ){
				
				super(				);
				
				
				
				
				
				this.comments = comments ;
				this.originalCompilationUnit = originalCompilationUnit ;
				this.originalClassFile = originalClassFile ;
			}
			
			
			
			
			
			
			
			public void setComments(Comment comments) {
				this.comments = comments;
			}
				
			public Comment getComments() {
				return comments;
			}
			
			public void setOriginalCompilationUnit(CompilationUnit originalCompilationUnit) {
				this.originalCompilationUnit = originalCompilationUnit;
			}
				
			public CompilationUnit getOriginalCompilationUnit() {
				return originalCompilationUnit;
			}
			
			public void setOriginalClassFile(ClassFile originalClassFile) {
				this.originalClassFile = originalClassFile;
			}
				
			public ClassFile getOriginalClassFile() {
				return originalClassFile;
			}
			
		}
	