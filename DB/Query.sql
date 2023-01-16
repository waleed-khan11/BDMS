USE [master]
GO

/****** Object:  Table [dbo].[donor]    Script Date: 1/16/2023 11:16:07 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[donor](
	[Reg#] [varchar](50) NOT NULL,
	[firstName] [varchar](50) NOT NULL,
	[lastName] [varchar](50) NOT NULL,
	[bloodtype] [varchar](50) NOT NULL,
	[age] [varchar](50) NOT NULL,
	[city] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Reg#] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

